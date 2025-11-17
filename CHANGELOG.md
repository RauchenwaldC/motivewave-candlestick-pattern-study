# Candlestick Patterns Study - Changelog

## [1.0.0] - 2025-11-17

### Initial Release

Complete replacement of ORB Indicator with comprehensive candlestick pattern recognition study.

### Features

- **35+ Pattern Detection**: Recognizes bullish, bearish, and neutral candlestick patterns
- **Single-Bar Patterns**: Hammer, Shooting Star, Doji, Marubozu, and more
- **Double-Bar Patterns**: Engulfing, Harami, Piercing Line, Dark Cloud Cover, and more
- **Triple-Bar Patterns**: Morning/Evening Star, Three White Soldiers, Three Black Crows, and more
- **Visual Markers**: Colored arrows with tooltips showing pattern names
  - Green triangles (bottom) for bullish patterns
  - Red triangles (top) for bearish patterns
  - Orange circles (center) for neutral patterns
- **Customizable Display**: Configure colors, sizes, and styles for each marker type
- **Toggle Pattern Types**: Enable/disable bullish, bearish, or neutral pattern detection

### Technical Details

- **Study Type**: Pattern Recognition Study (non-trading)
- **Namespace**: `com.motivewave`
- **Study ID**: `CANDLESTICK_PATTERNS`
- **Menu Location**: General
- **Overlay Support**: Yes
- **Signal Support**: Yes (pattern detection events)
- **Bar Updates Required**: No

### Pattern Recognition Logic

Uses sophisticated algorithms based on:

- Body-to-range ratios
- Shadow lengths
- Multi-candle relationships
- Open/close positioning
- Traditional candlestick analysis rules

### Reference

Patterns based on the [Chart Guys Candlestick Pattern Cheat Sheet](https://www.chartguys.com/candlestick-pattern-cheat-sheet)

---

## Previous Versions (ORB Indicator)

This codebase previously contained an ORB (Opening Range Breakout) Indicator which has been completely replaced with the Candlestick Patterns Study.

- **URL**: <git@github.com>:RauchenwaldC/motivewave-orb-indicator.git

- **Branch**: main## Usage

## Future Enhancements### Strategy Settings

Potential improvements for the indicator:1. **AUTO mode (Recommended)**:

- Set `Market Open Time` to "AUTO"

- Additional visual customization options   - Strategy automatically detects market open from instrument configuration

- Multiple timeframe support   - Works for stocks, futures, forex, etc.

- Extended session time configurations

- Advanced signal filtering options2. **Manual mode**:

- Performance optimizations   - Set `Market Open Time` to specific time like "09:30", "06:00", etc.
  - Useful for custom trading hours or backtesting specific times

### Example Configurations

#### US Stocks (AUTO)

- Market Open Time: AUTO
- OR Period: 5 candles
- Automatically uses 09:30 ET for NYSE/NASDAQ

#### ES Futures (AUTO)

- Market Open Time: AUTO  
- OR Period: 5 candles
- Automatically uses instrument's configured RTH open time

#### Custom Schedule

- Market Open Time: 10:00
- OR Period: 3 candles
- Uses manual 10:00 in instrument's timezone

## Git Repository

- **URL**: <git@github.com>:RauchenwaldC/motivewave-orb-indicator.git
- **Branch**: main
- **Commits**:
  - Latest: Add AUTO market open detection
  - Previous: Update strategy branding
  - Previous: Simplify ORB Strategy

## Future Enhancements

The simplified strategy provides a solid base for incremental additions:

- Optional VWAP filter (toggle on/off)
- Optional EMA trend filter (toggle on/off)
- Configurable partial profit targets
- Additional trailing stop methods
- Pre-market gap analysis
- Entry window restrictions
