# Candlestick Patterns Study for MotiveWave

## Overview

The **Candlestick Patterns Study** is a comprehensive MotiveWave study that automatically detects and highlights bullish, bearish, and neutral candlestick patterns on your charts. This study recognizes over 30 different patterns including single-bar, double-bar, and triple-bar formations with visual markers and tooltips.

## Features

### Pattern Detection

The study detects the following categories of patterns:

#### Single-Bar Patterns

**Bullish:**

- Hammer
- Inverted Hammer
- Dragonfly Doji
- Bullish Marubozu

**Bearish:**

- Shooting Star
- Hanging Man
- Gravestone Doji
- Bearish Marubozu

**Neutral:**

- Doji
- Long-Legged Doji
- Spinning Top

#### Double-Bar Patterns

**Bullish:**

- Bullish Engulfing
- Bullish Harami
- Piercing Line
- Tweezer Bottom
- Bullish Kicker

**Bearish:**

- Bearish Engulfing
- Bearish Harami
- Dark Cloud Cover
- Tweezer Top
- Bearish Kicker

#### Triple-Bar Patterns

**Bullish:**

- Morning Star
- Morning Doji Star
- Bullish Abandoned Baby
- Three White Soldiers
- Three Inside Up
- Three Outside Up

**Bearish:**

- Evening Star
- Evening Doji Star
- Bearish Abandoned Baby
- Three Black Crows
- Three Inside Down
- Three Outside Down

### Visual Elements

- **Colored Arrows**: Each pattern is marked with a colored arrow
  - Green triangles (bottom) for bullish patterns
  - Red triangles (top) for bearish patterns
  - Orange circles (center) for neutral patterns
- **Tooltips**: Hover over any marker to see the pattern name
- **Customizable Markers**: Adjust colors, sizes, and styles

### Configuration Options

- **Pattern Detection**: Enable/disable bullish, bearish, or neutral pattern detection
- **Marker Customization**: Change colors, sizes, and styles for each pattern type
- **Visual Settings**: Customize the appearance of all markers

## Installation

### Using build.sh (Recommended)

1. Run the build script:

   ```bash
   chmod +x build.sh
   ./build.sh
   ```

2. Copy the JAR file to MotiveWave:

   ```bash
   cp dist/CandlestickPatterns-1.0.0.jar ~/MotiveWave/extensions/
   ```

3. Restart MotiveWave

### Manual Installation

1. Compile the study using MotiveWave's study compilation process
2. Place the compiled JAR in your MotiveWave extensions directory
3. Restart MotiveWave to load the new study

## Usage

1. **Add Study**: Right-click chart → Studies → General → Candlestick Patterns
2. **Configure Settings**:
   - Enable/disable pattern types (bullish, bearish, neutral)
   - Customize marker colors and sizes
   - Adjust visual appearance
3. **Analyze**: Patterns are automatically detected and displayed with tooltips

## Parameters

| Parameter | Description | Default |
|-----------|-------------|---------|
| Detect Bullish Patterns | Show bullish pattern markers | true |
| Detect Bearish Patterns | Show bearish pattern markers | true |
| Detect Neutral Patterns | Show neutral pattern markers | true |
| Bullish Marker | Marker style for bullish patterns | Green triangle |
| Bearish Marker | Marker style for bearish patterns | Red triangle |
| Neutral Marker | Marker style for neutral patterns | Orange circle |

## File Structure

```
Candlestick-Patterns/
├── src/
│   └── CandlestickPatterns.java  # Main study implementation
├── docs/                          # MotiveWave SDK documentation
├── example/                       # MotiveWave study examples
├── build.sh                       # Build script
├── deploy.sh                      # Development deployment script
├── MANIFEST.MF                    # JAR manifest file
├── CHANGELOG.md                   # Version history
└── README.md                      # This file
```

## Technical Details

- **Namespace**: `com.motivewave`
- **Study ID**: `CANDLESTICK_PATTERNS`
- **Menu Location**: General
- **Overlay**: Yes (displays on price chart)
- **Signal Support**: Yes (pattern detection events)
- **Bar Updates Required**: No

## Pattern Recognition Logic

The study uses sophisticated algorithms to identify patterns based on:

- Body-to-range ratios
- Shadow lengths
- Multi-candle relationships
- Open/close positioning
- High/low comparisons

Each pattern is checked according to traditional candlestick analysis rules as documented in the [Chart Guys Candlestick Pattern Cheat Sheet](https://www.chartguys.com/candlestick-pattern-cheat-sheet).

## Version History

See [CHANGELOG.md](CHANGELOG.md) for detailed version history.

## License

This study is provided as-is for use with MotiveWave platform. See MotiveWave license terms for usage rights.

## Support

For issues or questions about this study, please refer to the MotiveWave documentation or community forums.
