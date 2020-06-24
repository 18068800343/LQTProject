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

function setZpzltj(){

}