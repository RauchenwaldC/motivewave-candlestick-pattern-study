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
- **Signal Support**: Emits trading signals for bullish and bearish patterns that can trigger alerts or automated strategies

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

### Download from GitHub Releases (Recommended)

1. **Download the JAR file**:
   - Go to [Releases](https://github.com/RauchenwaldC/motivewave-candlestick-pattern-study/releases)
   - Download `CandlestickPatterns.jar` from the latest release

2. **Import into MotiveWave**:
   - Open MotiveWave
   - Click **Study** menu in the top menu bar
   - Select **All Studies**
   - Click **Import** button in the dialog
   - Navigate to and select the downloaded JAR file
   - Click **OK**

3. **Add to Chart**:
   - In the **All Studies** dialog, search for "Candlestick Patterns"
   - Select it and click **Add** to add it to your chart

### Building from Source

If you want to modify the study or build it yourself:

1. **Prerequisites**:
   - Java 21 or higher
   - MotiveWave installed on your system

2. **Build the JAR**:

   ```bash
   chmod +x build.sh
   ./build.sh
   ```

   The JAR will be created in `dist/CandlestickPatterns.jar`

3. **Import to MotiveWave** (same as above):
   - Study → All Studies → Import → Select the JAR from `dist/` folder

### Development & Testing

For rapid development iteration:

```bash
chmod +x deploy.sh
./deploy.sh
```

This script:

- Compiles the study
- Deploys directly to `~/MotiveWave Extensions/dev/`
- MotiveWave automatically reloads the study (if running)
- Ideal for testing changes without manual import/restart

## Usage

1. **Add Study to Chart**:
   - Study menu → All Studies
   - Search for "Candlestick Patterns"
   - Click **Add**

2. **Configure Settings**:
   - Right-click the study on chart → Edit Study
   - Enable/disable pattern types (bullish, bearish, neutral)
   - Toggle pattern complexity (1-bar, 2-bar, 3-bar patterns)
   - Customize marker colors and sizes
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
- **Signal Support**: Yes (emits BULLISH_PATTERN and BEARISH_PATTERN signals)
- **Bar Updates Required**: Yes (for real-time pattern detection)

## Signals

The study emits two types of signals that can be used for alerts and automated trading:

### BULLISH_PATTERN

- **Triggered**: When a bullish candlestick pattern is detected
- **Data**: Pattern name and closing price
- **Use Cases**: Long entry signals, bullish reversal alerts, trend confirmation

### BEARISH_PATTERN

- **Triggered**: When a bearish candlestick pattern is detected
- **Data**: Pattern name and closing price
- **Use Cases**: Short entry signals, bearish reversal alerts, exit signals

To use signals:

1. Right-click on the study → Signals
2. Enable "BULLISH_PATTERN" and/or "BEARISH_PATTERN"
3. Configure alerts or connect to trading strategies

## Pattern Recognition Logic

The study uses sophisticated algorithms to identify patterns based on:

- Body-to-range ratios
- Shadow lengths
- Multi-candle relationships
- Open/close positioning
- High/low comparisons

Each pattern is checked according to traditional candlestick analysis rules as documented in the [Chart Guys Candlestick Pattern Cheat Sheet](https://www.chartguys.com/candlestick-pattern-cheat-sheet).

## Contributing

Contributions are welcome! Here's how you can help:

### Reporting Issues

If you encounter bugs or have feature requests:

1. Check [existing issues](https://github.com/RauchenwaldC/motivewave-candlestick-pattern-study/issues) first
2. Create a new issue using the issue template
3. Provide detailed information:
   - MotiveWave version
   - Study version
   - Steps to reproduce
   - Expected vs actual behavior
   - Screenshots if applicable

### Submitting Changes

1. **Fork the repository**
2. **Create a feature branch**:

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make your changes**:
   - Follow existing code style
   - Test thoroughly using `./deploy.sh`
   - Update documentation if needed

4. **Commit your changes**:

   ```bash
   git commit -m "Add: description of your changes"
   ```

5. **Push and create a Pull Request**:

   ```bash
   git push origin feature/your-feature-name
   ```

### Development Guidelines

- Test all pattern detection changes on various chart timeframes
- Ensure backward compatibility with existing configurations
- Document any new settings or features in README.md
- Update CHANGELOG.md with your changes

## Version History

See [CHANGELOG.md](CHANGELOG.md) for detailed version history.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

This means you are free to use, modify, and distribute this study, even for commercial purposes, with proper attribution.

## Support

**Note**: This is an open-source project provided as-is without official support.

### Getting Help

- **Documentation**: Check this README and [PATTERNS.md](PATTERNS.md)
- **Issues**: Report bugs via [GitHub Issues](https://github.com/RauchenwaldC/motivewave-candlestick-pattern-study/issues)
- **MotiveWave**: For platform-specific questions, consult [MotiveWave documentation](https://www.motivewave.com/support.htm)

### No Warranty

This software is provided "as is", without warranty of any kind. Use at your own risk.
