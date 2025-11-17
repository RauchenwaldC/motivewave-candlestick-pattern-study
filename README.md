# Candlestick Patterns Study for MotiveWave

## Overview

The **Candlestick Patterns Study** is a comprehensive MotiveWave study that automatically detects and highlights bullish, bearish, and neutral candlestick patterns on your charts. This study recognizes over 30 different patterns including single-bar, double-bar, and triple-bar formations with visual markers and tooltips.

## Features

### Pattern Detection

The study detects **33+ candlestick patterns** across three categories. For detailed descriptions of each pattern, see [PATTERNS.md](PATTERNS.md).

#### Single-Bar Patterns

**Bullish:**

- [Hammer](PATTERNS.md#1-hammer)
- [Inverted Hammer](PATTERNS.md#2-inverted-hammer)
- [Dragonfly Doji](PATTERNS.md#3-dragonfly-doji)
- [Bullish Marubozu](PATTERNS.md#4-bullish-marubozu)

**Bearish:**

- [Shooting Star](PATTERNS.md#5-shooting-star)
- [Hanging Man](PATTERNS.md#6-hanging-man)
- [Gravestone Doji](PATTERNS.md#7-gravestone-doji)
- [Bearish Marubozu](PATTERNS.md#8-bearish-marubozu)

**Neutral:**

- [Doji](PATTERNS.md#9-doji)
- [Long-Legged Doji](PATTERNS.md#10-long-legged-doji)
- [Spinning Top](PATTERNS.md#11-spinning-top)

#### Double-Bar Patterns

**Bullish:**

- [Bullish Engulfing](PATTERNS.md#12-bullish-engulfing)
- [Bullish Harami](PATTERNS.md#13-bullish-harami)
- [Piercing Line](PATTERNS.md#14-piercing-line)
- [Tweezer Bottom](PATTERNS.md#15-tweezer-bottom)
- [Bullish Kicker](PATTERNS.md#16-bullish-kicker)

**Bearish:**

- [Bearish Engulfing](PATTERNS.md#17-bearish-engulfing)
- [Bearish Harami](PATTERNS.md#18-bearish-harami)
- [Dark Cloud Cover](PATTERNS.md#19-dark-cloud-cover)
- [Tweezer Top](PATTERNS.md#20-tweezer-top)
- [Bearish Kicker](PATTERNS.md#21-bearish-kicker)

#### Triple-Bar Patterns

**Bullish:**

- [Morning Star](PATTERNS.md#22-morning-star)
- [Morning Doji Star](PATTERNS.md#23-morning-doji-star)
- [Bullish Abandoned Baby](PATTERNS.md#24-bullish-abandoned-baby)
- [Three White Soldiers](PATTERNS.md#25-three-white-soldiers)
- [Three Inside Up](PATTERNS.md#26-three-inside-up)
- [Three Outside Up](PATTERNS.md#27-three-outside-up)

**Bearish:**

- [Evening Star](PATTERNS.md#28-evening-star)
- [Evening Doji Star](PATTERNS.md#29-evening-doji-star)
- [Bearish Abandoned Baby](PATTERNS.md#30-bearish-abandoned-baby)
- [Three Black Crows](PATTERNS.md#31-three-black-crows)
- [Three Inside Down](PATTERNS.md#32-three-inside-down)
- [Three Outside Down](PATTERNS.md#33-three-outside-down)

### Visual Elements

- **Colored Arrows**: Each pattern is marked with a colored arrow
  - Green triangles (bottom) for bullish patterns
  - Red triangles (top) for bearish patterns
  - Orange circles (center) for neutral patterns
- **Tooltips**: Hover over any marker to see the pattern name and its meaning
- **Customizable Markers**: Adjust colors, sizes, and styles
- **Smart Detection**: Prevents duplicate markings of the same pattern in continuous trends

### Configuration Options

#### Pattern Types

- **Detect Bullish Patterns**: Enable/disable bullish pattern detection
- **Detect Bearish Patterns**: Enable/disable bearish pattern detection
- **Detect Neutral Patterns**: Enable/disable neutral pattern detection

#### Pattern Complexity

- **Detect 1-Bar Patterns**: Toggle single-bar patterns (Doji, Hammer, Marubozu, etc.)
- **Detect 2-Bar Patterns**: Toggle double-bar patterns (Engulfing, Harami, Piercing Line, etc.)
- **Detect 3-Bar Patterns**: Toggle triple-bar patterns (Morning/Evening Star, Three White Soldiers, etc.)

#### Display Settings

- **Bullish Marker**: Customize color, size, and style for bullish patterns
- **Bearish Marker**: Customize color, size, and style for bearish patterns
- **Neutral Marker**: Customize color, size, and style for neutral patterns

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
| Detect 1-Bar Patterns | Show single-bar patterns | true |
| Detect 2-Bar Patterns | Show double-bar patterns | true |
| Detect 3-Bar Patterns | Show triple-bar patterns | true |
| Bullish Marker | Marker style for bullish patterns | Green arrow (bottom) |
| Bearish Marker | Marker style for bearish patterns | Red arrow (top) |
| Neutral Marker | Marker style for neutral patterns | Orange circle (center) |

## File Structure

```text
Candlestick-Patterns/
├── src/
│   └── CandlestickPatterns.java  # Main study implementation
├── build.sh                       # Build script
├── deploy.sh                      # Development deployment script
├── MANIFEST.MF                    # JAR manifest file
├── CHANGELOG.md                   # Version history
├── PATTERNS.md                    # Detailed pattern reference guide
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
