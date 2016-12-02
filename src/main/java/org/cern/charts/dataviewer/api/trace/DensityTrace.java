package org.cern.charts.dataviewer.api.trace;

import org.cern.charts.dataviewer.utils.TraceColour;
import org.cern.charts.dataviewer.utils.TraceMode;
import org.cern.charts.dataviewer.utils.TraceType;
import org.cern.charts.dataviewer.utils.TraceVisibility;

public class DensityTrace<T extends Number> extends GenericTrace<T> {
	
	public DensityTrace(Histogram2dContourTrace<T> h2dc, HistogramTrace<T> xh, HistogramTrace<T> yx) {
		setTraceName("Density Trace");
		setTraceColour(TraceColour.ORANGE);
		setTraceMode(TraceMode.LINES);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	public DensityTrace(String traceName) {
		setTraceName(traceName);
		setTraceType(TraceType.LINE);
		setTraceColour(TraceColour.ORANGE);
		setTraceMode(TraceMode.LINES);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	@Override
	public void setConfiguration(TraceConfiguration config) {
		this.traceConfig = config;
		this.traceConfig.setTraceType(TraceType.LINE);
	}

}
