




Dataviewer is a data visualization tool for JavaFX.

It is based on [Plotly.js](https://plot.ly/javascript/), [JavaFx](http://docs.oracle.com/javase/8/javase-clienttechnologies.htm), [Jetty](http://www.eclipse.org/jetty/) and Websockets.


##Requirements

* Recent version of Java installed supporting JavaFX.

##Installation
Maven installation :

	<dependency>
		<groupId>charts</groupId>
		<artifactId>javafx-dataviewer</artifactId>
		<version>{latest.version}</version>
	</dependency>


## API


* DataViewer
* DataViewerConfiguration
* Trace
* TraceConfiguration
* PlotData

#### DataViewer & DataViewerConfiguration
DataViewer is the main plotting window. It is configured by the DataViewerConfiguration.

With DataViewer you can :

1. Update your Plot Configuration
2. Update your Plot Data
3. Reset your Plot Data


##### DataViewer

	updatePlot(PlotData data); 					             // Updates the plot
	updatePlotConfiguration(DataViewerConfiguration config); // Updates the dataviewer (window) configuration.
	getUniqueID(); // Get the unique ID of the dataviewer -  // navigate http://localhost:8090/view/UNIQUE_ID/

##### DataViewerConfiguration




	setPlotTitle(String title);				 // plot title
	setxAxisTitle(String title);			 // x axis title
	setyAxisTitle(String title); 			 // x axis title
	setMarginTop(int margin);				// margin top
	setMarginBottom(int margin);			// margin bottom
	setMarginRight(int margin);				// margin right
	setMarginLeft(int margin);				// margin left
	setPadding(int padding);				// padding
	setxRange(double min, double max);     // Set the range of the x axis of the dataviewer
	setyRange(double min, double max);     // Set the range of the x axis of the dataviewer
	setxAxisType(AxisType type);			 // Set the axis type of x axis (log or linear)
	setyAxisType(AxisType type);			 // Set the axis type of y axis (log or linear)
	showLegend(boolean set);				// Show/hide Legend
	setLegendInsidePlot(boolean inside);   	// Show legend inside plot



See usage example below:


	// Create dataviewer
	DataViewer dataviewer = new DataViewer();

	// Create dataviewer configuration
	DataViewerConfiguration config = new DataViewerConfiguration();
	// Plot title
	config.setPlotTitle("Line Trace Example");
	// X axis title
	config.setxAxisTitle("X Example 1");
	// Y axis title
	config.setyAxisTitle("Y Example 1");

	// Update the configuration
	dataviewer.sendConfiguration(config);

	// Container of traces
	PlotData plotData = new PlotData(new LineTrace<Float>());

	// Plot all traces in the container.
	dataviewer.updatePlot(plotData);


Resetting the dataviewer example:

	DataViewer dataviewer = new DataViewer();
	DataViewerConfiguration config = new DataViewerConfiguration();
	dataviewer.sendConfiguration(config);
	PlotData plotData = new PlotData();
	dataviewer.updatePlot(plotData);

	// Reset your Plot (removes all trace from the dataviewer)
	dataviewer.resetPlot();



#### Traces
Traces are the different kind of plots that are going to be drawed in the DataViewer.
Provided Traces:

* GenericTrace\<T>
* LineTrace\<T>
* ScatterTrace\<T>
* BarTrace\<T>
* TimeSeriesTrace\<T>
* HistogramTrace\<T>
* ContourTrace\<T>

More to be provided..


##### GenericTrace

GenericTrace is an abstract class that all traces inherit from.

It can be used as a container when the type of the trace is not known.

See usage example below:


	Methods:

	// Config
	setTraceName(String traceName); 			             // Updates the plot
	setConfiguration(TraceConfiguration traceConfig)         // Set the trace configuration
	setTraceColour(TraceColour colour); 	                 // Set trace Colour
	setTraceMode(TraceMode mode);                            // Set the trace mode (LINES, MARKERS, MARKERS_AND_LINES)
	setTraceType(TraceType traceType);                       // Set the trace Type (BAR, LINE, SCATTER, CONTOUR ...)
	setTraceVisibility(TraceVisibility visibility);          // Visibility of the trace(TRUE, FALSE, LEGENDONLY)

	// Data
	setxAxis(T[] xAxis);
	setyAxis(T[] xAxis);
	setzAxis(T[] zAxis);

##### GenericTrace Example - abstract class ( should not be used like this! )

	GenericTrace<Double> genericTrace = new LineTrace<>();
	genericTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	genericTrace.setyArray(new Double[]  { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	genericTrace.setTraceColour(TraceColour.PURPLE);
	genericTrace.setTraceName("Line Trace");
	genericTrace.setTraceType(TraceType.LINE);
	genericTrace.setTraceMode(TraceMode.LINES);
	genericTrace.setTraceVisibility(TraceVisibility.TRUE);


##### LineTrace


Example:

	LineTrace<Double> lineTrace = new LineTrace<>();
	lineTrace.setTraceName("MyLineTrace");
	lineTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	lineTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	lineTrace.setTraceColour(TraceColour.PURPLE);


Example with configuration object:

	LineTrace<Double> lineTrace = new LineTrace<>();
	lineTrace.setTraceName("MyLineTrace");

	lineTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	lineTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

	TraceConfiguration lineConfig = new TraceConfiguration();
	lineConfig.setTraceColour(TraceColour.RED);
	lineTrace.setConfiguration(lineConfig);				

##### BarTrace


Example:

	BarTrace<Object> barTrace = new BarTrace<>();
	barTrace.setTraceName("MyBarTrace");
	barTrace.setxArray(new String[] { "one", "two", "three", "four", "five", "six" });
	barTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	barTrace.setTraceColour(TraceColour.PURPLE);


Example with configuration object:

	BarTrace<Object> barTrace = new BarTrace<>();
	barTrace.setTraceName("MyBarTrace");

	barTrace.setxArray(new String[] { "one", "two", "three", "four", "five", "six" });
	barTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

	TraceConfiguration barConfig = new TraceConfiguration();
	barConfig.setTraceColour(TraceColour.RED);
	barTrace.setConfiguration(barConfig);				

##### ScatterTrace


Example:

	Scatter<Float> scatterTrace = new ScatterTrace<>();
	scatterTrace.setTraceName("MyScatterTrace");
	scatterTrace.setxArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	scatterTrace.setyArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	scatterTrace.setTraceColour(TraceColour.PURPLE);


Example with configuration object:

	ScatterTrace<Double> scatterTrace = new ScatterTrace<>();
	scatterTrace.setTraceName("MyScatterTrace");

	scatterTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
	scatterTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

	TraceConfiguration scatterConfig = new TraceConfiguration();
	scatterConfig.setTraceColour(TraceColour.RED);
	scatterTrace.setConfiguration(scatterConfig);


##### TimeSeriesTrace


Example:

	TimeSeries<Object> timeSeriesTrace = new TimeSeriesTrace<>();
	timeSeriesTrace.setTraceName("MyTimeSeriesTrace");

	timeSeriesTrace.setxArray(new String[] { "2013-10-04 22:23:00", "2013-10-05 22:23:01", "2013-10-06 22:23:02", "2013-10-07 	22:23:03", "2013-10-08 22:23:04", "2013-10-09 22:23:05", "2013-10-10 22:23:06" });
	timeSeriesTrace.setyArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

	timeSeriesTrace.setTraceColour(TraceColour.PURPLE);


Example with configuration object:

	TimeSeriesTrace<Double> timeSeriesTrace = new TimeSeriesTrace<>();
	timeSeriesTrace.setTraceName("MyTimeSeriesTrace");

	timeSeriesTrace.setxArray(new String[] { "2013-10-04 22:23:00", "2013-10-05 22:23:01", "2013-10-06 22:23:02", "2013-10-07 	22:23:03", "2013-10-08 22:23:04", "2013-10-09 22:23:05", "2013-10-10 22:23:06" });
	timeSeriesTrace.setyArray(new Float[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });

	TraceConfiguration timeSeriesConfig = new TraceConfiguration();
	timeSeriesTrace.setTraceColour(TraceColour.RED);
	timeSeriesTrace.setConfiguration(timeSeriesConfig);




##### CountourTrace


Example:


	ContourTrace<Double> contourTrace = new ContourTrace<>();

	contourTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
	contourTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
	contourTrace.setzArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });

	contourTrace.setTraceName("ContourTrace");



Example with configuration object:


	ContourTrace<Double> contourTrace = new ContourTrace<>();

	contourTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
	contourTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
	contourTrace.setzArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });

	TraceConfiguration contourConfig = new TraceConfiguration();
	contourConfig.setTraceName("ContourTrace");

	contourTrace.setConfiguration(contourConfig);







##### Histogram


Example:


	HistogramTrace<Double> histogramTrace = new HistogramTrace<>();
	histogramTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
	histogramTrace.setTraceName("MyHistogramTrace");
	histogramTrace.setTraceColour(TraceColour.BLUE);


Example with configuration object:

	HistogramTrace<Double> histogramTrace = new HistogramTrace<>();
	histogramTrace.setxArray(new Double[] { 0.0, 1.0, 200.0, 3.0, 4000.0, 5.0 });

	TraceConfiguration histogramConfig = new TraceConfiguration();
	histogramConfig.setTraceName("HistogramTrace");
	histogramConfig.setTraceColour(TraceColour.RED);

	histogramTrace.setConfiguration(histogramConfig);


## Features
###plotly.js features
You can find plotly features here:
[http://help.plot.ly/getting-to-know-the-plotly-modebar/](http://help.plot.ly/getting-to-know-the-plotly-modebar/)



### Dataviewer features
Additional Features have been added so far :


*	Change in logarithmic scales.
*	Data visualization in table.
*	Show/Move legend.
*	Export data to CSV.
*	Change trace type.
*	Date & time of the latest plot udpate





## Architecture Overview


DataViewer uses the embedded Jetty Server in order to create Websocket Endpoints and Serve Static Html & Javascript pages.
These pages will be loaded in the JavaFX WebView that the library is using.


**Overview of the architecture:**



#### Sequence diagram



## JavaFX Dataviewer Demo Project
Extensive usage of the dataviewer with examples can be found here :


## Licence

	The MIT License (MIT)

	Copyright (c) 2017    Iason Rodis

	Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation 	files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, 	modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the 	Software is furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all copies or substantial portions of the 	Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 	WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 	COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 	ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.




<!-- Highlight syntax for Mou.app, insert at the bottom of the markdown document  -->

<script src="http://yandex.st/highlightjs/7.3/highlight.min.js"></script>
<link rel="stylesheet" href="http://yandex.st/highlightjs/7.3/styles/github.min.css">
<script>
  hljs.initHighlightingOnLoad();
</script>

<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
}
<style>
