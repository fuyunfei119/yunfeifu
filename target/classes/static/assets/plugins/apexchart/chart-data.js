'use strict';

$(document).ready(function() {
	$.ajax({
		url:"/indexcharts",
		success:function (result) {
			let parse = JSON.parse(result);

			var options = {
				chart: {
					height: 350,
					type: "area",
					toolbar: {
						show: false
					},
				},
				dataLabels: {
					enabled: false
				},
				stroke: {
					curve: "smooth"
				},
				series:[
					{
					name: "Gehalt",
					data: JSON.parse(parse[0].a)

				}, {
					name: "Umsatz",
					color: '#FFBC53',
					data: JSON.parse(parse[0].b)
				}],
				xaxis: {
					categories:JSON.parse(parse[0].c)
				}

			};
			var chart = new ApexCharts(
				document.querySelector("#apexcharts-area"),
				options
			);

			chart.render();

			// Bar chart

			var optionsBar = {
				chart: {
					type: 'bar',
					height: 350,
					width: '100%',
					stacked: true,
					toolbar: {
						show: false
					},
				},
				dataLabels: {
					enabled: false
				},
				plotOptions: {
					bar: {
						columnWidth: '45%',
					}
				},
				series: [{
					name: "Abteilung",
					color: '#fdbb38',
					/*data: [420, 532, 516, 575, 519, 517, 454, 392, 262, 383, 446, 551, 563, 421, 563, 254, 452],*/
					data:JSON.parse(parse[0].e),
				}],
				/*labels: [2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020],*/
				labels:JSON.parse(parse[0].d),
				xaxis: {
					labels: {
						show: false
					},
					axisBorder: {
						show: false
					},
					axisTicks: {
						show: false
					},
				},
				yaxis: {
					axisBorder: {
						show: false
					},
					axisTicks: {
						show: false
					},
					labels: {
						style: {
							colors: '#777'
						}
					}
				},
				title: {
					text: '',
					align: 'left',
					style: {
						fontSize: '18px'
					}
				}

			}

			var chartBar = new ApexCharts(document.querySelector('#bar'), optionsBar);
			chartBar.render();
		}
	})
	// Area chart
});