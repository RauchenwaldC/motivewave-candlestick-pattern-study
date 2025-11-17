# Candlestick Patterns Reference

This document lists all the candlestick patterns detected by the Candlestick Patterns Study, organized by category and sentiment.

## Pattern Categories

- **Single-Bar Patterns**: Formed by one candlestick
- **Double-Bar Patterns**: Formed by two consecutive candlesticks
- **Triple-Bar Patterns**: Formed by three consecutive candlesticks

## Single-Bar Patterns (11 patterns)

### Bullish Patterns (4)

1. **Hammer**
   - Small body at top of range
   - Long lower shadow (at least 2x body)
   - Little/no upper shadow
   - Bullish candle (close > open)

2. **Inverted Hammer**
   - Small body at bottom of range
   - Long upper shadow (at least 2x body)
   - Little/no lower shadow
   - Bullish candle (close > open)

3. **Dragonfly Doji**
   - Very small body (< 10% of range)
   - Long lower shadow (> 60% of range)
   - Little/no upper shadow (< 10% of range)

4. **Bullish Marubozu**
   - Large bullish body (> 95% of range)
   - Little/no shadows on either end
   - Strong bullish momentum

### Bearish Patterns (4)

5. **Shooting Star**
   - Small body at bottom of range
   - Long upper shadow (at least 2x body)
   - Little/no lower shadow
   - Bearish candle (close < open)

6. **Hanging Man**
   - Small body at top of range
   - Long lower shadow (at least 2x body)
   - Little/no upper shadow
   - Bearish candle (close < open)

7. **Gravestone Doji**
   - Very small body (< 10% of range)
   - Long upper shadow (> 60% of range)
   - Little/no lower shadow (< 10% of range)

8. **Bearish Marubozu**
   - Large bearish body (> 95% of range)
   - Little/no shadows on either end
   - Strong bearish momentum

### Neutral Patterns (3)

9. **Doji**
   - Very small body (< 10% of range)
   - Can have shadows of any length
   - Indicates indecision

10. **Long-Legged Doji**
    - Very small body (< 10% of range)
    - Long shadows on both sides (> 2x body)
    - Strong indecision with volatility

11. **Spinning Top**
    - Small body (10-30% of range)
    - Relatively long shadows on both sides
    - Moderate indecision

## Double-Bar Patterns (10 patterns)

### Bullish Patterns (5)

12. **Bullish Engulfing**
    - First candle: Bearish
    - Second candle: Bullish, body engulfs previous body
    - Strong reversal signal

13. **Bullish Harami**
    - First candle: Large bearish body
    - Second candle: Small bullish body contained within first
    - Second body < 50% of first body

14. **Piercing Line**
    - First candle: Bearish
    - Second candle: Bullish, opens below previous close
    - Closes above midpoint of previous body

15. **Tweezer Bottom**
    - Two consecutive candles
    - Similar lows (within 5% of average range)
    - Support level formation

16. **Bullish Kicker**
    - First candle: Bearish
    - Second candle: Bullish, gaps up (open > previous open)
    - Strong momentum shift

### Bearish Patterns (5)

17. **Bearish Engulfing**
    - First candle: Bullish
    - Second candle: Bearish, body engulfs previous body
    - Strong reversal signal

18. **Bearish Harami**
    - First candle: Large bullish body
    - Second candle: Small bearish body contained within first
    - Second body < 50% of first body

19. **Dark Cloud Cover**
    - First candle: Bullish
    - Second candle: Bearish, opens above previous close
    - Closes below midpoint of previous body

20. **Tweezer Top**
    - Two consecutive candles
    - Similar highs (within 5% of average range)
    - Resistance level formation

21. **Bearish Kicker**
    - First candle: Bullish
    - Second candle: Bearish, gaps down (open < previous open)
    - Strong momentum shift

## Triple-Bar Patterns (12 patterns)

### Bullish Patterns (6)

22. **Morning Star**
    - First candle: Large bearish
    - Second candle: Small body (< 30% of first), gaps down
    - Third candle: Large bullish (> 50% of first)

23. **Morning Doji Star**
    - First candle: Bearish
    - Second candle: Doji that gaps down
    - Third candle: Bullish
    - Stronger than regular Morning Star

24. **Bullish Abandoned Baby**
    - Like Morning Star but middle candle gaps on both sides
    - Middle candle is a doji
    - Very rare and strong signal

25. **Three White Soldiers**
    - Three consecutive bullish candles
    - Each closes higher than previous
    - Strong uptrend continuation

26. **Three Inside Up**
    - First two candles: Bullish Harami
    - Third candle: Bullish, closes above first candle open
    - Confirmation pattern

27. **Three Outside Up**
    - First two candles: Bullish Engulfing
    - Third candle: Bullish, closes above second candle close
    - Confirmation pattern

### Bearish Patterns (6)

28. **Evening Star**
    - First candle: Large bullish
    - Second candle: Small body (< 30% of first), gaps up
    - Third candle: Large bearish (> 50% of first)

29. **Evening Doji Star**
    - First candle: Bullish
    - Second candle: Doji that gaps up
    - Third candle: Bearish
    - Stronger than regular Evening Star

30. **Bearish Abandoned Baby**
    - Like Evening Star but middle candle gaps on both sides
    - Middle candle is a doji
    - Very rare and strong signal

31. **Three Black Crows**
    - Three consecutive bearish candles
    - Each closes lower than previous
    - Strong downtrend continuation

32. **Three Inside Down**
    - First two candles: Bearish Harami
    - Third candle: Bearish, closes below first candle open
    - Confirmation pattern

33. **Three Outside Down**
    - First two candles: Bearish Engulfing
    - Third candle: Bearish, closes below second candle close
    - Confirmation pattern

## Visual Indicators

- **Bullish Patterns**: Green triangle marker at candle low with tooltip
- **Bearish Patterns**: Red triangle marker at candle high with tooltip
- **Neutral Patterns**: Orange circle marker at candle midpoint with tooltip

## Pattern Detection Logic

The study uses the following criteria to identify patterns:

1. **Body Size Ratios**: Compares candlestick body size to range
2. **Shadow Analysis**: Evaluates upper and lower shadow lengths
3. **Multi-Candle Relationships**: Checks open/close/high/low relationships across candles
4. **Gap Detection**: Identifies gaps between consecutive candles
5. **Trend Context**: Some patterns consider the position within the overall trend

All patterns follow traditional Japanese candlestick analysis rules as documented by technical analysis experts.

## Usage Tips

1. **Combine with Trend Analysis**: Patterns are more reliable when aligned with the overall trend
2. **Wait for Confirmation**: Consider waiting for the next candle to confirm the pattern
3. **Use with Support/Resistance**: Patterns at key levels are more significant
4. **Volume Confirmation**: Check volume for additional confirmation (not done by this study)
5. **Filter Settings**: Use the enable/disable toggles to focus on specific pattern types

## References

- [Chart Guys Candlestick Pattern Cheat Sheet](https://www.chartguys.com/candlestick-pattern-cheat-sheet)
- Japanese Candlestick Charting Techniques by Steve Nison
- Traditional Technical Analysis principles
