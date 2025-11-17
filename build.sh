#!/bin/bash
#
# Build script for Candlestick Patterns Study
# Creates a JAR file ready for MotiveWave platform
#

set -e  # Exit on error

echo "================================================"
echo "  Candlestick Patterns Study - Build Script"
echo "================================================"
echo ""

# Configuration
PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC_DIR="$PROJECT_DIR/src"
BUILD_DIR="$PROJECT_DIR/build"
CLASSES_DIR="$BUILD_DIR/classes"
DIST_DIR="$PROJECT_DIR/dist"
JAR_FILE="$DIST_DIR/CandlestickPatterns-1.0.0.jar"
MANIFEST="$PROJECT_DIR/MANIFEST.MF"

# MotiveWave SDK path (update this to your MotiveWave installation)
# Common locations:
#   macOS: /Applications/MotiveWave.app/Contents/Java/mwave_sdk.jar
#   Linux: ~/MotiveWave/mwave_sdk.jar
#   Windows: C:\Program Files\MotiveWave\mwave_sdk.jar

MOTIVEWAVE_JAR="$PROJECT_DIR/example/MotiveWave Studies/lib/mwave_sdk.jar"

# Check if MotiveWave JAR exists
if [ ! -f "$MOTIVEWAVE_JAR" ]; then
    echo "❌ ERROR: MotiveWave SDK JAR not found at: $MOTIVEWAVE_JAR"
    echo ""
    echo "Please update MOTIVEWAVE_JAR variable in this script to point to your MotiveWave installation."
    echo ""
    echo "Common locations:"
    echo "  macOS: /Applications/MotiveWave.app/Contents/Java/mwave_sdk.jar"
    echo "  Linux: ~/MotiveWave/mwave_sdk.jar"
    echo "  Windows: C:\\Program Files\\MotiveWave\\mwave_sdk.jar"
    echo ""
    exit 1
fi

echo "✓ Found MotiveWave JAR: $MOTIVEWAVE_JAR"
echo ""


# Clean build and dist directories
echo "🧹 Cleaning build and dist directories..."
rm -rf "$BUILD_DIR"
rm -rf "$DIST_DIR"
mkdir -p "$CLASSES_DIR"
mkdir -p "$DIST_DIR"
echo "✓ Build and dist directories cleaned"
echo ""

# Compile Java sources
echo "🔨 Compiling Java sources..."
javac -cp "$MOTIVEWAVE_JAR" \
      -d "$CLASSES_DIR" \
      -source 11 -target 11 \
      "$SRC_DIR"/*.java

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful"
else
    echo "❌ Compilation failed"
    exit 1
fi
echo ""


# Create JAR file
echo "📦 Creating JAR file..."
cd "$CLASSES_DIR"
jar cvfm "$JAR_FILE" "$MANIFEST" com/ > /dev/null

if [ $? -eq 0 ]; then
    echo "✓ JAR file created: $JAR_FILE"
else
    echo "❌ JAR creation failed"
    exit 1
fi
cd "$PROJECT_DIR"
echo ""

# Display JAR info
echo "================================================"
echo "  Build Complete!"
echo "================================================"
echo ""
echo "📦 JAR File: $JAR_FILE"
echo "📏 Size: $(du -h "$JAR_FILE" | cut -f1)"
echo ""
echo "📋 Contents:"
jar tf "$JAR_FILE"
echo ""
echo "================================================"
echo "  Installation Instructions"
echo "================================================"
echo ""
echo "1. Copy the JAR file to MotiveWave extensions directory:"
echo "   macOS: ~/MotiveWave/extensions/"
echo "   Linux: ~/MotiveWave/extensions/"
echo "   Windows: C:\\Users\\YourName\\MotiveWave\\extensions\\"
echo ""
echo "2. Restart MotiveWave"
echo ""
echo "3. The study will appear under: Studies → General → Candlestick Patterns"
echo ""
echo "To copy now, run:"
echo "  cp $JAR_FILE ~/MotiveWave/extensions/"
echo ""
