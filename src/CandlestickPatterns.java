package com.motivewave.platform.study.general;

import com.motivewave.platform.sdk.common.*;
import com.motivewave.platform.sdk.common.desc.*;
import com.motivewave.platform.sdk.study.*;
import com.motivewave.platform.sdk.draw.*;

import java.awt.Color;

/**
 * Candlestick Pattern Recognition Study
 * 
 * Detects and highlights bullish, bearish, and neutral candlestick patterns
 * including single-bar, double-bar, and triple-bar formations.
 */
@StudyHeader(namespace = "com.motivewave", id = "CANDLESTICK_PATTERNS", name = "Candlestick Patterns", label = "Candlestick Patterns", desc = "Detects and highlights bullish, bearish, and neutral candlestick patterns", menu = "General", overlay = true, studyOverlay = true, signals = true, requiresBarUpdates = false)
public class CandlestickPatterns extends Study {

    enum PatternType {
        BULLISH, BEARISH, NEUTRAL
    }

    @Override
    public void initialize(Defaults defaults) {
        var sd = createSD();
        var tab = sd.addTab("General");

        // Pattern Detection Settings
        var grp = tab.addGroup("Pattern Types");
        grp.addRow(new BooleanDescriptor("detectBullish", "Detect Bullish Patterns", true));
        grp.addRow(new BooleanDescriptor("detectBearish", "Detect Bearish Patterns", true));
        grp.addRow(new BooleanDescriptor("detectNeutral", "Detect Neutral Patterns", true));

        // Display Settings
        tab = sd.addTab("Display");
        grp = tab.addGroup("Markers");
        grp.addRow(new MarkerDescriptor("bullishMarker", "Bullish Pattern",
                Enums.MarkerType.ARROW, Enums.Size.MEDIUM,
                new Color(34, 139, 34), defaults.getLineColor(), true, true));
        grp.addRow(new MarkerDescriptor("bearishMarker", "Bearish Pattern",
                Enums.MarkerType.ARROW, Enums.Size.MEDIUM,
                new Color(220, 20, 60), defaults.getLineColor(), true, true));
        grp.addRow(new MarkerDescriptor("neutralMarker", "Neutral Pattern",
                Enums.MarkerType.CIRCLE, Enums.Size.MEDIUM,
                new Color(255, 165, 0), defaults.getLineColor(), true, true));

        // Runtime Descriptor
        var desc = createRD();
        desc.setLabelSettings();
    }

    @Override
    protected void calculateValues(DataContext ctx) {
        var series = ctx.getDataSeries();
        var settings = getSettings();

        boolean detectBullish = settings.getBoolean("detectBullish", true);
        boolean detectBearish = settings.getBoolean("detectBearish", true);
        boolean detectNeutral = settings.getBoolean("detectNeutral", true);

        // Clear all figures before redrawing
        clearFigures();

        // Track the last pattern detected to avoid repeating
        String lastPattern = null;
        int lastPatternIndex = -1;

        // Iterate through all bars and check for patterns
        for (int index = 3; index < series.size(); index++) {
            // Check patterns in order of priority: triple, double, single
            // This ensures more complex/specific patterns take precedence
            String pattern = null;
            PatternType type = null;

            // === TRIPLE-BAR PATTERNS (HIGHEST PRIORITY) ===

            // Bullish triple-bar patterns
            if (detectBullish) {
                if (pattern == null) {
                    pattern = checkMorningStar(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkMorningDojiStar(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkBullishAbandonedBaby(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkThreeWhiteSoldiers(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkThreeInsideUp(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkThreeOutsideUp(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
            }

            // Bearish triple-bar patterns
            if (detectBearish) {
                if (pattern == null) {
                    pattern = checkEveningStar(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkEveningDojiStar(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkBearishAbandonedBaby(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkThreeBlackCrows(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkThreeInsideDown(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkThreeOutsideDown(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
            }

            // === DOUBLE-BAR PATTERNS (MEDIUM PRIORITY) ===

            // Bullish double-bar patterns
            if (detectBullish && pattern == null) {
                if (pattern == null) {
                    pattern = checkBullishEngulfing(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkBullishHarami(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkPiercingLine(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkTweezerBottom(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkBullishKicker(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
            }

            // Bearish double-bar patterns
            if (detectBearish && pattern == null) {
                if (pattern == null) {
                    pattern = checkBearishEngulfing(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkBearishHarami(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkDarkCloudCover(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkTweezerTop(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkBearishKicker(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
            }

            // === SINGLE-BAR PATTERNS (LOWEST PRIORITY) ===

            // Bullish single-bar patterns
            if (detectBullish && pattern == null) {
                // More specific doji patterns first
                if (pattern == null) {
                    pattern = checkDragonflyDoji(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkHammer(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkInvertedHammer(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
                if (pattern == null) {
                    pattern = checkBullishMarubozu(index, series);
                    if (pattern != null)
                        type = PatternType.BULLISH;
                }
            }

            // Bearish single-bar patterns
            if (detectBearish && pattern == null) {
                // More specific doji patterns first
                if (pattern == null) {
                    pattern = checkGravestoneDoji(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkShootingStar(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkHangingMan(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
                if (pattern == null) {
                    pattern = checkBearishMarubozu(index, series);
                    if (pattern != null)
                        type = PatternType.BEARISH;
                }
            }

            // Neutral single-bar patterns (check these last)
            if (detectNeutral && pattern == null) {
                // More specific doji patterns first
                if (pattern == null) {
                    pattern = checkLongLeggedDoji(index, series);
                    if (pattern != null)
                        type = PatternType.NEUTRAL;
                }
                if (pattern == null) {
                    pattern = checkDoji(index, series);
                    if (pattern != null)
                        type = PatternType.NEUTRAL;
                }
                if (pattern == null) {
                    pattern = checkSpinningTop(index, series);
                    if (pattern != null)
                        type = PatternType.NEUTRAL;
                }
            }

            // Only draw marker if:
            // 1. A pattern was detected, AND
            // 2. It's different from the last pattern OR it's been at least 1 bar since the
            // last occurrence
            if (pattern != null && type != null) {
                boolean shouldDraw = true;

                // Skip if same pattern as previous candle (to avoid repetition)
                if (pattern.equals(lastPattern) && index == lastPatternIndex + 1) {
                    shouldDraw = false;
                }

                if (shouldDraw) {
                    drawPattern(index, series, settings, pattern, type);
                    lastPattern = pattern;
                    lastPatternIndex = index;
                }
            }

            series.setComplete(index);
        }
    }

    @Override
    protected void calculate(int index, DataContext ctx) {
        // This method is called for each bar during real-time updates
        // We don't need to do anything here since calculateValues() handles everything
        // Just mark the bar as complete
        ctx.getDataSeries().setComplete(index);
    }

    private void drawPattern(int index, DataSeries series, Settings settings, String patternName, PatternType type) {
        long barTime = series.getStartTime(index);
        double price;
        Enums.Position position;
        MarkerInfo marker;

        switch (type) {
            case BULLISH:
                price = series.getLow(index);
                position = Enums.Position.BOTTOM;
                marker = settings.getMarker("bullishMarker");
                break;
            case BEARISH:
                price = series.getHigh(index);
                position = Enums.Position.TOP;
                marker = settings.getMarker("bearishMarker");
                break;
            default: // NEUTRAL
                price = (series.getHigh(index) + series.getLow(index)) / 2.0;
                position = Enums.Position.CENTER;
                marker = settings.getMarker("neutralMarker");
                break;
        }

        if (marker.isEnabled()) {
            var coord = new Coordinate(barTime, price);
            String tooltip = patternName + "\n" + getPatternMeaning(patternName);
            addFigure(new Marker(coord, position, marker, tooltip));
        }
    }

    // Get pattern meaning from Chart Guys definitions
    private String getPatternMeaning(String patternName) {
        switch (patternName) {
            // Single-Bar Patterns - Bullish
            case "Hammer":
                return "Found in downtrends, signaling potential bullish reversal as buyers step in at lower prices.";
            case "Inverted Hammer":
                return "Appears in downtrends; potential bullish reversal signal, suggesting buyer interest despite selling pressure.";
            case "Dragonfly Doji":
                return "Found in downtrends; signals potential bullish reversal as buyers reject lower prices, indicating support.";
            case "Bullish Marubozu":
                return "Shows strong buying pressure and bullish momentum, often marking sustained upward movement.";
            
            // Single-Bar Patterns - Bearish
            case "Shooting Star":
                return "Appears in uptrends; signals potential bearish reversal as sellers step in at higher prices.";
            case "Hanging Man":
                return "Found in uptrends; potential bearish reversal, suggesting weakening buying interest despite initial strength.";
            case "Gravestone Doji":
                return "Appears in uptrends; signals potential bearish reversal, indicating resistance as sellers reject higher prices.";
            case "Bearish Marubozu":
                return "Shows strong selling pressure and bearish momentum, often marking the start of sustained downward movement.";
            
            // Single-Bar Patterns - Neutral
            case "Doji":
                return "Indicates indecision in the market, with neither buyers nor sellers in control.";
            case "Long-Legged Doji":
                return "Reflects heightened volatility and uncertainty, with neither buyers nor sellers maintaining control.";
            case "Spinning Top":
                return "Indicates market indecision, showing balance between buyers and sellers with neither side dominating.";
            
            // Double-Bar Patterns - Bullish
            case "Bullish Engulfing":
                return "Found in downtrends; signals potential bullish reversal as buyers overwhelm sellers.";
            case "Bullish Harami":
                return "Seen in downtrends, it suggests indecision, with possible bullish reversal if the following candles confirm buying strength, indicating a weakening bearish trend.";
            case "Piercing Line":
                return "Found in downtrends, this pattern suggests a possible bullish reversal if buying continues, as sellers lose control to buyers.";
            case "Tweezer Bottom":
                return "Appears in downtrends; indicates possible bullish reversal as buyers defend the same support level twice.";
            case "Bullish Kicker":
                return "Found after downtrends or sell-offs; suggests a sudden shift in sentiment, indicating strong buying interest and potential trend reversal.";
            
            // Double-Bar Patterns - Bearish
            case "Bearish Engulfing":
                return "Found in uptrends; signals potential bearish reversal as sellers overwhelm buyers.";
            case "Bearish Harami":
                return "Seen in uptrends, it suggests indecision with a potential bearish reversal if following candles confirm, indicating a weakening bullish trend.";
            case "Dark Cloud Cover":
                return "Found in uptrends; signals potential bearish reversal if selling continues, as buyers lose control to sellers.";
            case "Tweezer Top":
                return "Appears in uptrends; indicates potential bearish reversal as sellers defend the same resistance level twice.";
            case "Bearish Kicker":
                return "Found after uptrends; indicates a sudden sentiment shift, signaling potential trend reversal and intensified selling pressure.";
            
            // Triple-Bar Patterns - Bullish
            case "Morning Star":
                return "Appears in downtrends; signals potential bullish reversal, with the small middle candle indicating indecision, followed by strong buying.";
            case "Morning Doji Star":
                return "Appears in downtrends; signals potential bullish reversal, with indecision from the doji and confirmation by a strong bullish candle.";
            case "Bullish Abandoned Baby":
                return "Appears in downtrends; suggests a strong bullish reversal, as the middle doji shows indecision, with confirmation by a strong bullish move.";
            case "Three White Soldiers":
                return "Found in downtrends; signals potential trend reversal, showing sustained buying strength, often signaling the start of a bullish trend.";
            case "Three Inside Up":
                return "Found in downtrends; confirms potential bullish reversal, showing building buying pressure as the trend shifts upward.";
            case "Three Outside Up":
                return "Found in downtrends; signals a confirmed bullish reversal, as buyers gain control and sustain upward momentum.";
            
            // Triple-Bar Patterns - Bearish
            case "Evening Star":
                return "Appears in uptrends; indicates potential bearish reversal, as the small middle candle shows indecision before strong selling.";
            case "Evening Doji Star":
                return "Appears in uptrends; signals potential bearish reversal, as the doji suggests indecision, confirmed by strong selling on the third candle.";
            case "Bearish Abandoned Baby":
                return "Appears in uptrends; indicates strong bearish reversal, as indecision in the doji is followed by selling strength.";
            case "Three Black Crows":
                return "Found in uptrends; signals potential bearish reversal, with sustained selling pressure often marking the start of a downtrend.";
            case "Three Inside Down":
                return "Found in uptrends; confirms potential bearish reversal, indicating weakening bullish pressure and a possible trend shift.";
            case "Three Outside Down":
                return "Found in uptrends; signals a confirmed bearish reversal, as sellers gain control and sustain downward momentum.";
            
            default:
                return "";
        }
    }

    // Helper methods for candlestick analysis
    private boolean isBullish(int index, DataSeries series) {
        return series.getClose(index) > series.getOpen(index);
    }

    private boolean isBearish(int index, DataSeries series) {
        return series.getClose(index) < series.getOpen(index);
    }

    private double getBodySize(int index, DataSeries series) {
        return Math.abs(series.getClose(index) - series.getOpen(index));
    }

    private double getUpperShadow(int index, DataSeries series) {
        return series.getHigh(index) - Math.max(series.getOpen(index), series.getClose(index));
    }

    private double getLowerShadow(int index, DataSeries series) {
        return Math.min(series.getOpen(index), series.getClose(index)) - series.getLow(index);
    }

    private double getRange(int index, DataSeries series) {
        return series.getHigh(index) - series.getLow(index);
    }

    private double getAvgBodySize(int index, DataSeries series, int periods) {
        double sum = 0;
        int count = 0;
        for (int i = 1; i <= periods && (index - i) >= 0; i++) {
            sum += getBodySize(index - i, series);
            count++;
        }
        return count > 0 ? sum / count : 0;
    }

    // === SINGLE-BAR PATTERNS ===

    private String checkDoji(int index, DataSeries series) {
        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);
        if (range == 0)
            return null;

        // Body is very small relative to range
        if (bodySize / range < 0.1) {
            return "Doji";
        }
        return null;
    }

    private String checkLongLeggedDoji(int index, DataSeries series) {
        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);
        double upperShadow = getUpperShadow(index, series);
        double lowerShadow = getLowerShadow(index, series);

        if (range == 0)
            return null;

        // Very small body with long shadows on both sides
        if (bodySize / range < 0.1 &&
                upperShadow > bodySize * 2 &&
                lowerShadow > bodySize * 2) {
            return "Long-Legged Doji";
        }
        return null;
    }

    private String checkDragonflyDoji(int index, DataSeries series) {
        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);
        double upperShadow = getUpperShadow(index, series);
        double lowerShadow = getLowerShadow(index, series);

        if (range == 0)
            return null;

        // Very small body, long lower shadow, little/no upper shadow
        if (bodySize / range < 0.1 &&
                lowerShadow > range * 0.6 &&
                upperShadow < range * 0.1) {
            return "Dragonfly Doji";
        }
        return null;
    }

    private String checkGravestoneDoji(int index, DataSeries series) {
        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);
        double upperShadow = getUpperShadow(index, series);
        double lowerShadow = getLowerShadow(index, series);

        if (range == 0)
            return null;

        // Very small body, long upper shadow, little/no lower shadow
        if (bodySize / range < 0.1 &&
                upperShadow > range * 0.6 &&
                lowerShadow < range * 0.1) {
            return "Gravestone Doji";
        }
        return null;
    }

    private String checkSpinningTop(int index, DataSeries series) {
        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);
        double upperShadow = getUpperShadow(index, series);
        double lowerShadow = getLowerShadow(index, series);

        if (range == 0)
            return null;

        // Small body (but not doji) with relatively long shadows
        if (bodySize / range > 0.1 && bodySize / range < 0.3 &&
                upperShadow > bodySize &&
                lowerShadow > bodySize) {
            return "Spinning Top";
        }
        return null;
    }

    private String checkHammer(int index, DataSeries series) {
        if (!isBullish(index, series))
            return null;

        double bodySize = getBodySize(index, series);
        double lowerShadow = getLowerShadow(index, series);
        double upperShadow = getUpperShadow(index, series);

        // Long lower shadow (at least 2x body), small/no upper shadow
        if (lowerShadow > bodySize * 2 && upperShadow < bodySize * 0.5) {
            return "Hammer";
        }
        return null;
    }

    private String checkInvertedHammer(int index, DataSeries series) {
        if (!isBullish(index, series))
            return null;

        double bodySize = getBodySize(index, series);
        double upperShadow = getUpperShadow(index, series);
        double lowerShadow = getLowerShadow(index, series);

        // Long upper shadow (at least 2x body), small/no lower shadow
        if (upperShadow > bodySize * 2 && lowerShadow < bodySize * 0.5) {
            return "Inverted Hammer";
        }
        return null;
    }

    private String checkShootingStar(int index, DataSeries series) {
        if (!isBearish(index, series))
            return null;

        double bodySize = getBodySize(index, series);
        double upperShadow = getUpperShadow(index, series);
        double lowerShadow = getLowerShadow(index, series);

        // Long upper shadow (at least 2x body), small/no lower shadow
        if (upperShadow > bodySize * 2 && lowerShadow < bodySize * 0.5) {
            return "Shooting Star";
        }
        return null;
    }

    private String checkHangingMan(int index, DataSeries series) {
        if (!isBearish(index, series))
            return null;

        double bodySize = getBodySize(index, series);
        double lowerShadow = getLowerShadow(index, series);
        double upperShadow = getUpperShadow(index, series);

        // Long lower shadow (at least 2x body), small/no upper shadow
        if (lowerShadow > bodySize * 2 && upperShadow < bodySize * 0.5) {
            return "Hanging Man";
        }
        return null;
    }

    private String checkBullishMarubozu(int index, DataSeries series) {
        if (!isBullish(index, series))
            return null;

        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);

        if (range == 0)
            return null;

        // Body is almost entire range (little/no shadows)
        if (bodySize / range > 0.95) {
            return "Bullish Marubozu";
        }
        return null;
    }

    private String checkBearishMarubozu(int index, DataSeries series) {
        if (!isBearish(index, series))
            return null;

        double bodySize = getBodySize(index, series);
        double range = getRange(index, series);

        if (range == 0)
            return null;

        // Body is almost entire range (little/no shadows)
        if (bodySize / range > 0.95) {
            return "Bearish Marubozu";
        }
        return null;
    }

    // === DOUBLE-BAR PATTERNS ===

    private String checkBullishEngulfing(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bearish, current is bullish
        if (!isBearish(index - 1, series) || !isBullish(index, series))
            return null;

        // Current body engulfs previous body
        if (series.getOpen(index) <= series.getClose(index - 1) &&
                series.getClose(index) >= series.getOpen(index - 1)) {
            return "Bullish Engulfing";
        }
        return null;
    }

    private String checkBearishEngulfing(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bullish, current is bearish
        if (!isBullish(index - 1, series) || !isBearish(index, series))
            return null;

        // Current body engulfs previous body
        if (series.getOpen(index) >= series.getClose(index - 1) &&
                series.getClose(index) <= series.getOpen(index - 1)) {
            return "Bearish Engulfing";
        }
        return null;
    }

    private String checkBullishHarami(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bearish with large body, current is bullish with small body
        if (!isBearish(index - 1, series) || !isBullish(index, series))
            return null;

        double prevBody = getBodySize(index - 1, series);
        double currBody = getBodySize(index, series);

        // Current body is contained within previous body
        if (currBody < prevBody * 0.5 &&
                series.getOpen(index) > series.getClose(index - 1) &&
                series.getClose(index) < series.getOpen(index - 1)) {
            return "Bullish Harami";
        }
        return null;
    }

    private String checkBearishHarami(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bullish with large body, current is bearish with small body
        if (!isBullish(index - 1, series) || !isBearish(index, series))
            return null;

        double prevBody = getBodySize(index - 1, series);
        double currBody = getBodySize(index, series);

        // Current body is contained within previous body
        if (currBody < prevBody * 0.5 &&
                series.getOpen(index) < series.getClose(index - 1) &&
                series.getClose(index) > series.getOpen(index - 1)) {
            return "Bearish Harami";
        }
        return null;
    }

    private String checkPiercingLine(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bearish, current is bullish
        if (!isBearish(index - 1, series) || !isBullish(index, series))
            return null;

        // Current opens below previous close, closes above midpoint of previous body
        double prevMid = (series.getOpen(index - 1) + series.getClose(index - 1)) / 2.0;
        if (series.getOpen(index) < series.getClose(index - 1) &&
                series.getClose(index) > prevMid &&
                series.getClose(index) < series.getOpen(index - 1)) {
            return "Piercing Line";
        }
        return null;
    }

    private String checkDarkCloudCover(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bullish, current is bearish
        if (!isBullish(index - 1, series) || !isBearish(index, series))
            return null;

        // Current opens above previous close, closes below midpoint of previous body
        double prevMid = (series.getOpen(index - 1) + series.getClose(index - 1)) / 2.0;
        if (series.getOpen(index) > series.getClose(index - 1) &&
                series.getClose(index) < prevMid &&
                series.getClose(index) > series.getOpen(index - 1)) {
            return "Dark Cloud Cover";
        }
        return null;
    }

    private String checkTweezerBottom(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Two candles with similar lows
        double lowDiff = Math.abs(series.getLow(index) - series.getLow(index - 1));
        double avgRange = (getRange(index, series) + getRange(index - 1, series)) / 2.0;

        if (avgRange == 0)
            return null;

        // Lows are very close (within 5% of average range)
        if (lowDiff / avgRange < 0.05) {
            // Verify opposing candle colors (typically one bearish, one bullish)
            boolean firstBullish = isBullish(index - 1, series);
            boolean secondBullish = isBullish(index, series);

            if (firstBullish != secondBullish) {
                return "Tweezer Bottom";
            }
        }
        return null;
    }

    private String checkTweezerTop(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Two candles with similar highs
        double highDiff = Math.abs(series.getHigh(index) - series.getHigh(index - 1));
        double avgRange = (getRange(index, series) + getRange(index - 1, series)) / 2.0;

        if (avgRange == 0)
            return null;

        // Highs are very close (within 5% of average range)
        if (highDiff / avgRange < 0.05) {
            // Verify opposing candle colors (typically one bullish, one bearish)
            boolean firstBullish = isBullish(index - 1, series);
            boolean secondBullish = isBullish(index, series);

            if (firstBullish != secondBullish) {
                return "Tweezer Top";
            }
        }
        return null;
    }

    private String checkBullishKicker(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bearish, current is bullish
        if (!isBearish(index - 1, series) || !isBullish(index, series))
            return null;

        // Gap up: current open is above previous open
        if (series.getOpen(index) > series.getOpen(index - 1)) {
            return "Bullish Kicker";
        }
        return null;
    }

    private String checkBearishKicker(int index, DataSeries series) {
        if (index < 1)
            return null;

        // Previous bar is bullish, current is bearish
        if (!isBullish(index - 1, series) || !isBearish(index, series))
            return null;

        // Gap down: current open is below previous open
        if (series.getOpen(index) < series.getOpen(index - 1)) {
            return "Bearish Kicker";
        }
        return null;
    }

    // === TRIPLE-BAR PATTERNS ===

    private String checkMorningStar(int index, DataSeries series) {
        if (index < 2)
            return null;

        // First candle: large bearish
        // Second candle: small body (star)
        // Third candle: large bullish
        if (!isBearish(index - 2, series) || !isBullish(index, series))
            return null;

        double firstBody = getBodySize(index - 2, series);
        double secondBody = getBodySize(index - 1, series);
        double thirdBody = getBodySize(index, series);

        // Second candle has small body, gaps down from first
        if (secondBody < firstBody * 0.3 &&
                Math.max(series.getOpen(index - 1), series.getClose(index - 1)) < series.getClose(index - 2) &&
                thirdBody > firstBody * 0.5) {
            return "Morning Star";
        }
        return null;
    }

    private String checkEveningStar(int index, DataSeries series) {
        if (index < 2)
            return null;

        // First candle: large bullish
        // Second candle: small body (star)
        // Third candle: large bearish
        if (!isBullish(index - 2, series) || !isBearish(index, series))
            return null;

        double firstBody = getBodySize(index - 2, series);
        double secondBody = getBodySize(index - 1, series);
        double thirdBody = getBodySize(index, series);

        // Second candle has small body, gaps up from first
        if (secondBody < firstBody * 0.3 &&
                Math.min(series.getOpen(index - 1), series.getClose(index - 1)) > series.getClose(index - 2) &&
                thirdBody > firstBody * 0.5) {
            return "Evening Star";
        }
        return null;
    }

    private String checkMorningDojiStar(int index, DataSeries series) {
        if (index < 2)
            return null;

        // Like morning star but middle candle is a doji
        if (!isBearish(index - 2, series) || !isBullish(index, series))
            return null;

        double secondBody = getBodySize(index - 1, series);
        double secondRange = getRange(index - 1, series);

        if (secondRange == 0)
            return null;

        // Middle candle is doji, gaps down
        if (secondBody / secondRange < 0.1 &&
                series.getHigh(index - 1) < series.getClose(index - 2)) {
            return "Morning Doji Star";
        }
        return null;
    }

    private String checkEveningDojiStar(int index, DataSeries series) {
        if (index < 2)
            return null;

        // Like evening star but middle candle is a doji
        if (!isBullish(index - 2, series) || !isBearish(index, series))
            return null;

        double secondBody = getBodySize(index - 1, series);
        double secondRange = getRange(index - 1, series);

        if (secondRange == 0)
            return null;

        // Middle candle is doji, gaps up
        if (secondBody / secondRange < 0.1 &&
                series.getLow(index - 1) > series.getClose(index - 2)) {
            return "Evening Doji Star";
        }
        return null;
    }

    private String checkThreeWhiteSoldiers(int index, DataSeries series) {
        if (index < 2)
            return null;

        // Three consecutive bullish candles with higher closes
        if (!isBullish(index - 2, series) || !isBullish(index - 1, series) || !isBullish(index, series)) {
            return null;
        }

        // Each candle closes higher than previous
        if (series.getClose(index - 1) > series.getClose(index - 2) &&
                series.getClose(index) > series.getClose(index - 1)) {
            return "Three White Soldiers";
        }
        return null;
    }

    private String checkThreeBlackCrows(int index, DataSeries series) {
        if (index < 2)
            return null;

        // Three consecutive bearish candles with lower closes
        if (!isBearish(index - 2, series) || !isBearish(index - 1, series) || !isBearish(index, series)) {
            return null;
        }

        // Each candle closes lower than previous
        if (series.getClose(index - 1) < series.getClose(index - 2) &&
                series.getClose(index) < series.getClose(index - 1)) {
            return "Three Black Crows";
        }
        return null;
    }

    private String checkBullishAbandonedBaby(int index, DataSeries series) {
        if (index < 2)
            return null;

        // Like morning star but with gaps on both sides of middle candle
        if (!isBearish(index - 2, series) || !isBullish(index, series))
            return null;

        double secondBody = getBodySize(index - 1, series);
        double secondRange = getRange(index - 1, series);

        if (secondRange == 0)
            return null;

        // Middle is doji, gaps down from first and up from third
        if (secondBody / secondRange < 0.1 &&
                series.getHigh(index - 1) < series.getLow(index - 2) &&
                series.getHigh(index - 1) < series.getLow(index)) {
            return "Bullish Abandoned Baby";
        }
        return null;
    }

    private String checkBearishAbandonedBaby(int index, DataSeries series) {
        if (index < 2)
            return null;

        // Like evening star but with gaps on both sides of middle candle
        if (!isBullish(index - 2, series) || !isBearish(index, series))
            return null;

        double secondBody = getBodySize(index - 1, series);
        double secondRange = getRange(index - 1, series);

        if (secondRange == 0)
            return null;

        // Middle is doji, gaps up from first and down from third
        if (secondBody / secondRange < 0.1 &&
                series.getLow(index - 1) > series.getHigh(index - 2) &&
                series.getLow(index - 1) > series.getHigh(index)) {
            return "Bearish Abandoned Baby";
        }
        return null;
    }

    private String checkThreeInsideUp(int index, DataSeries series) {
        if (index < 2)
            return null;

        // First two candles form bullish harami, third confirms
        if (!isBearish(index - 2, series) || !isBullish(index - 1, series) || !isBullish(index, series)) {
            return null;
        }

        // Second is contained in first, third closes above first
        if (series.getOpen(index - 1) > series.getClose(index - 2) &&
                series.getClose(index - 1) < series.getOpen(index - 2) &&
                series.getClose(index) > series.getOpen(index - 2)) {
            return "Three Inside Up";
        }
        return null;
    }

    private String checkThreeInsideDown(int index, DataSeries series) {
        if (index < 2)
            return null;

        // First two candles form bearish harami, third confirms
        if (!isBullish(index - 2, series) || !isBearish(index - 1, series) || !isBearish(index, series)) {
            return null;
        }

        // Second is contained in first, third closes below first
        if (series.getOpen(index - 1) < series.getClose(index - 2) &&
                series.getClose(index - 1) > series.getOpen(index - 2) &&
                series.getClose(index) < series.getOpen(index - 2)) {
            return "Three Inside Down";
        }
        return null;
    }

    private String checkThreeOutsideUp(int index, DataSeries series) {
        if (index < 2)
            return null;

        // First two candles form bullish engulfing, third confirms
        if (!isBearish(index - 2, series) || !isBullish(index - 1, series) || !isBullish(index, series)) {
            return null;
        }

        // Second engulfs first, third closes higher
        if (series.getOpen(index - 1) <= series.getClose(index - 2) &&
                series.getClose(index - 1) >= series.getOpen(index - 2) &&
                series.getClose(index) > series.getClose(index - 1)) {
            return "Three Outside Up";
        }
        return null;
    }

    private String checkThreeOutsideDown(int index, DataSeries series) {
        if (index < 2)
            return null;

        // First two candles form bearish engulfing, third confirms
        if (!isBullish(index - 2, series) || !isBearish(index - 1, series) || !isBearish(index, series)) {
            return null;
        }

        // Second engulfs first, third closes lower
        if (series.getOpen(index - 1) >= series.getClose(index - 2) &&
                series.getClose(index - 1) <= series.getOpen(index - 2) &&
                series.getClose(index) < series.getClose(index - 1)) {
            return "Three Outside Down";
        }
        return null;
    }
}
