package org.cern.charts.dataviewer.api.trace;

import org.cern.charts.dataviewer.utils.TraceMode;
import org.cern.charts.dataviewer.utils.TraceType;
import org.cern.charts.dataviewer.utils.TraceVisibility;

public class ScatterTrace<T> extends GenericTrace<T> {

	public ScatterTrace() {
		setTraceName("Scatter Trace");
		setTraceType(TraceType.SCATTER);
		setTraceMode(TraceMode.MARKERS);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	public ScatterTrace(String traceName) {
		setTraceName(traceName);
		setTraceType(TraceType.SCATTER);
		setTraceMode(TraceMode.MARKERS);
		setTraceVisibility(TraceVisibility.TRUE);
	}

	@Override
	public void setConfiguration(TraceConfiguration config) {
		this.traceConfig = config;
		this.traceConfig.setTraceType(TraceType.SCATTER);
		this.traceConfig.setTraceMode(TraceMode.MARKERS);
	}
}
