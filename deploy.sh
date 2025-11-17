#!/bin/bash
#
# Candlestick Patterns Study - Development Deployment Script
# Based on MotiveWave SDK official build patterns
#
# This script compiles the study and deploys class files to
# the MotiveWave Extensions dev directory for hot-reload testing.
#

set -e  # Exit on error

echo "================================================"
echo "  Candlestick Patterns Study - Development Deploy"
echo "================================================"
echo ""

# Configuration
PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC_DIR="$PROJECT_DIR/src"
BUILD_DIR="$PROJECT_DIR/build"
CLASSES_DIR="$BUILD_DIR/classes"

# MotiveWave Extensions directory
EXT_DIR="$HOME/MotiveWave Extensions"
DEV_DIR="$EXT_DIR/dev"

# MotiveWave SDK JAR path (update if different)
MOTIVEWAVE_JAR="/Applications/MotiveWave.app/Contents/Java/mwave_sdk.jar"

# Also try the example SDK JAR which might be newer
EXAMPLE_JAR="$PROJECT_DIR/example/MotiveWave Studies/lib/mwave_sdk.jar"
if [ -f "$EXAMPLE_JAR" ]; then
    MOTIVEWAVE_JAR="$EXAMPLE_JAR"
    echo "Using example SDK JAR: $MOTIVEWAVE_JAR"
fi

# Alternative paths to check
ALT_PATHS=(
    "/Applications/MotiveWave.app/Contents/Java/mwave_sdk.jar"
    "$HOME/MotiveWave/mwave_sdk.jar"
    "/opt/MotiveWave/mwave_sdk.jar"
)

# Find MotiveWave JAR
if [ ! -f "$MOTIVEWAVE_JAR" ]; then
    echo "⚠️  Default MotiveWave JAR not found, searching..."
    FOUND=false
    for path in "${ALT_PATHS[@]}"; do
        if [ -f "$path" ]; then
            MOTIVEWAVE_JAR="$path"
            FOUND=true
            echo "✓ Found MotiveWave JAR: $MOTIVEWAVE_JAR"
            break
        fi
    done
    
    if [ "$FOUND" = false ]; then
        echo "❌ ERROR: MotiveWave SDK JAR not found"
        echo ""
        echo "Please update MOTIVEWAVE_JAR in this script to point to:"
        echo "  macOS: /Applications/MotiveWave.app/Contents/Java/mwave_sdk.jar"
        echo "  Linux: ~/MotiveWave/mwave_sdk.jar"
        echo "  Windows: C:\\Program Files\\MotiveWave\\mwave_sdk.jar"
        echo ""
        exit 1
    fi
else
    echo "✓ Found MotiveWave JAR: $MOTIVEWAVE_JAR"
fi
echo ""

# Clean and create build directory
echo "🧹 Cleaning build directory..."
rm -rf "$BUILD_DIR"
mkdir -p "$CLASSES_DIR"
echo "✓ Build directory ready"
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

# Deploy to MotiveWave Extensions
echo "📦 Deploying to MotiveWave Extensions..."

# Create extensions directory if it doesn't exist
mkdir -p "$EXT_DIR"

# Remove old dev directory to clean up moved/renamed files
if [ -d "$DEV_DIR" ]; then
    echo "  Removing old dev directory..."
    rm -rf "$DEV_DIR"
fi

# Create dev directory
mkdir -p "$DEV_DIR"

# Copy all class files
echo "  Copying class files..."
cp -r "$CLASSES_DIR"/* "$DEV_DIR/"

# Touch .last_updated to trigger MotiveWave reload
echo "  Triggering MotiveWave reload..."
touch "$EXT_DIR/.last_updated"

echo "✓ Deployment complete"
echo ""

# Show deployed files
echo "================================================"
echo "  Deployment Summary"
echo "================================================"
echo ""
echo "📁 Deployed to: $DEV_DIR"
echo "📄 Files deployed:"
find "$DEV_DIR" -name "*.class" -type f | sed 's|.*/dev/||'
echo ""
echo "================================================"
echo "  Next Steps"
echo "================================================"
echo ""
echo "1. MotiveWave will automatically reload (if running)"
echo "2. If not running, launch MotiveWave"
echo "3. Open a chart"
echo "4. Right-click → Studies → General → ORB Indicator"
echo ""
echo "✅ Indicator ready to use!"
echo ""
