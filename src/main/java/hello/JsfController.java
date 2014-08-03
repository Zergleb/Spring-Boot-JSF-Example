package hello;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("view")
public class JsfController {
	@Autowired
	TestService testService;

	int counter = 0;

	private String jsfTestString = "This string came from server side";

	public void doSomething() {
		setJsfTestString(testService.getMessage() + " " + counter++);
	}

	private LineChartModel areaModel;

	public LineChartModel getAreaModel() {
		if (areaModel == null) {
			createAreaModel();
		}
		return areaModel;
	}

	private void createAreaModel() {
		areaModel = new LineChartModel();

		LineChartSeries boys = new LineChartSeries();
		boys.setFill(true);
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		LineChartSeries girls = new LineChartSeries();
		girls.setFill(true);
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 90);
		girls.set("2008", 120);

		areaModel.addSeries(boys);
		areaModel.addSeries(girls);

		areaModel.setTitle("Area Chart");
		areaModel.setLegendPosition("ne");
		areaModel.setStacked(true);
		areaModel.setShowPointLabels(true);

		Axis xAxis = new CategoryAxis("Years");
		areaModel.getAxes().put(AxisType.X, xAxis);
		Axis yAxis = areaModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(300);
	}

	public String getJsfTestString() {
		return jsfTestString;
	}

	public void setJsfTestString(String jsfTestString) {
		this.jsfTestString = jsfTestString;
	}

}
