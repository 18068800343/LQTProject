function setHomeLDGXTJ(xuqiu,gongying,roadname){
	//		折线图1
	option = {

		legend: {
			data: ['总需求量', '总供应量']
		},
		tooltip: {
			trigger: 'axis'
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		xAxis: {
			type: 'category',
			axisTick: { //y轴刻度线
				show: false
			},
			axisLine: { //y轴
				show: false
			},
			splitLine: {
				show: false
			},
			boundaryGap: false,
			data: roadname,
			axisLabel : {
				formatter: function (params) {
					let newParamsName = "";
					let paramsNameNumber = params.length;
					let provideNumber = 3;
					let rowNumber = Math.ceil(paramsNameNumber / provideNumber);
					if (paramsNameNumber > provideNumber) {
						for (let p = 0; p < rowNumber; p++) {
							let tempStr = "";
							let start = p * provideNumber;
							let end = start + provideNumber;
							if (p == rowNumber - 1) {
								tempStr = params.substring(start, paramsNameNumber);
							} else {
								tempStr = params.substring(start, end) + "\n";
							}
							newParamsName += tempStr;
						}

					} else {
						newParamsName = params;
					}
					return newParamsName
				}
			}
		},
		yAxis: {
			type: 'value',

			axisTick: { //y轴刻度线
				show: false
			},
			axisLine: { //y轴
				show: false
			},
			splitLine: {
				show: false
			},
			splitLine: { //网格线
				lineStyle: {
					type: 'dashed' //设置网格线类型 dotted：虚线   solid:实线
				},
				show: true,

			},
			axisLabel: {
				formatter: function (value, index) {
					return value + "%";
				}
			}
		},
		series: [

			{
				name: '总需求量',
				type: 'line',
				stack: '总量',
				smooth: true, //这个是把线变成曲线
				data: xuqiu,
				lineStyle: {
					color: '#70FEFF'
				},
				itemStyle: {
					normal: {
						color: '#70FEFF'
					}
				}
			},
			{
				name: '总供应量',
				type: 'line',
				stack: '总量',
				smooth: true, //这个是把线变成曲线
				data: gongying,
				lineStyle: {
					color: '#8780FF'
				},
				itemStyle: {
					normal: {
						color: '#8780FF'
					}
				}
			}

		]
	};

	return option;
}

function setHomeZPZHTJ(dayTime,totalWeight){
//		柱状图
	option = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {            // 坐标轴指示器，坐标轴触发有效
				type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		color: ['#7FE0FF'],
		xAxis: {
			type: 'category',
			data: dayTime,
			axisTick: { //y轴刻度线
				show: false
			},
			axisLine: { //y轴
				show: false
			},
			splitLine: {
				show: false
			},
			axisLabel : {
				formatter: function (params) {
					let newParamsName = "";
					let paramsNameNumber = params.length;
					let provideNumber = 4;
					let rowNumber = Math.ceil(paramsNameNumber / provideNumber);
					if (paramsNameNumber > provideNumber) {
						for (let p = 0; p < rowNumber; p++) {
							let tempStr = "";
							let start = p * provideNumber;
							let end = start + provideNumber;
							if (p == rowNumber - 1) {
								tempStr = params.substring(start, paramsNameNumber);
							} else {
								tempStr = params.substring(start, end) + "\n";
							}
							newParamsName += tempStr;
						}

					} else {
						newParamsName = params;
					}
					return newParamsName
				}
			}
		},
		yAxis: {
			type: 'value',
			axisTick: { //y轴刻度线
				show: false
			},
			axisLine: { //y轴
				show: false
			},
			splitLine: {
				show: false
			},
			splitLine: { //网格线
				lineStyle: {
					type: 'dashed' //设置网格线类型 dotted：虚线   solid:实线
				},
				show: true,

			},
			axisLabel: {
				formatter: function (value, index) {
					return value + "吨";
				}
			}
		},
		series: [{
			data: totalWeight,
			type: 'bar',
			barWidth: '30%',

		}]
	};
	return option;
}

function setHomeCBJDTJ(datetime,chenneng,feiliao){
	//		柱状图
	option = {
		color: ['#4F9DFF', '#ff9d4e'],
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['日实际产能', '每日废料']
		},
		calculable: true,
		xAxis: [{
			type: 'category',
			axisTick: { //y轴刻度线
				show: false
			},
			axisLine: { //y轴
				show: false
			},
			splitLine: {
				show: false
			},
			data: datetime,
			axisLabel : {
				formatter: function (params) {
					let newParamsName = "";
					let paramsNameNumber = params.length;
					let provideNumber = 5;
					let rowNumber = Math.ceil(paramsNameNumber / provideNumber);
					if (paramsNameNumber > provideNumber) {
						for (let p = 0; p < rowNumber; p++) {
							let tempStr = "";
							let start = p * provideNumber;
							let end = start + provideNumber;
							if (p == rowNumber - 1) {
								tempStr = params.substring(start, paramsNameNumber);
							} else {
								tempStr = params.substring(start, end) + "\n";
							}
							newParamsName += tempStr;
						}

					} else {
						newParamsName = params;
					}
					return newParamsName
				}
			}
		}],
		yAxis: [{
			type: 'value',
			axisTick: { //y轴刻度线
				show: false
			},
			axisLine: { //y轴
				show: false
			},
			splitLine: {
				show: false
			},
			splitLine: { //网格线
				lineStyle: {
					type: 'dashed' //设置网格线类型 dotted：虚线   solid:实线
				},
				show: true,

			},
			axisLabel: {
				formatter: function (value, index) {
					return value + "吨";
				}
			}
		}],
		series: [{
			name: '日实际产能',
			type: 'bar',
			data: chenneng,
			barWidth: '30%',
			markPoint: {
				data: [

				]
			},
		},
			{
				name: '每日废料',
				type: 'bar',
				data: feiliao,
				barWidth: '30%',
				markPoint: {
					data: [

					]
				},
			}
		]
	};
	return option;
}