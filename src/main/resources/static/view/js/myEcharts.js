
function setCangChuEchartsConfig(echartsDom){
	echartsDom.config = {
		rotate: 90,
		align: 'left',
		verticalAlign: 'middle',
		position: 'insideBottom',
		distance: 15,
		onChange: function () {
			let labelOption = {
				normal: {
					rotate: echartsDom.config.rotate,
					align: echartsDom.config.align,
					verticalAlign: echartsDom.config.verticalAlign,
					position: echartsDom.config.position,
					distance: echartsDom.config.distance
				}
			};
			myChart.setOption({
				series: [{
					label: labelOption
				}, {
					label: labelOption
				}, {
					label: labelOption
				}, {
					label: labelOption
				}]
			});
		}
	};

}
let pageCangChuLabelOption;
function setLableOption(echartsDom){
	pageCangChuLabelOption = {
		normal: {
			show: true,
			formatter: '{c}  {name|{a}}',
			fontSize:15,
			rich: {
				name: {
					textBorderColor: '#fffdfc'
				}
			}
		}
	};
}

function setCangChuOption(map){
	let option = {
			color: ['#1F99EE', '#006699'],
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
					type: 'shadow'
				}
		    },
		    legend: {
		    	data: ['仓库容量', '剩余重量']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'value',
		        name:"重量",
		    },
		    yAxis: {
		    	name: '仓库编号',
				axisTick: {show: true},
				data: map.xList
		    },
		    series: [
		    	{
					name: '仓库容量',
					type: 'bar',
					barGap: 0,
					label: pageCangChuLabelOption,
					data: map.bList
				},
				{
					name: '剩余重量',
					type: 'bar',
					label: pageCangChuLabelOption,
					data: map.aList
				}
		    ]
		};

	return option;
}

function setCangChuPanDianOption(map) {
	/*let option = {
		title: {
			text: '仓储盘点'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['来料信息', '用料信息', '余料信息']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				saveAsImage: {}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: map.xList
		},
		yAxis: {
			type: 'value'
		},
		series: [
			{
				name: '来料信息',
				type: 'line',
				stack: '总量',
				data: map.aList
			},
			{
				name: '用料信息',
				type: 'line',
				stack: '总量',
				data: map.bList
			},
			{
				name: '余料信息',
				type: 'line',
				stack: '总量',
				data: map.cList
			}
		]
	};*/
	var option = {
		title: {
			text: '仓储盘点'
		},
		color: ['#FE545E','#6154FD','#006699'],
		textStyle: {
			color: '#black',
			fontSize: 13
		},
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross'
			}
		},

		legend: {
			data: ['来料信息', '用料信息', '余料信息'],
			itemGap: 80,
			textStyle: {
				color: '#17447E',
				fontSize: 13
			},

		},
		xAxis: [
			{
				type: 'category',
				data: map.xList
			}
		],
		yAxis: [
			{
				show:true,
				type: 'value',
				position: 'left',
				axisLine: {
					lineStyle: {
						color: "#black"
					}
				},
				axisLabel: {
					formatter: '{value} '
				}
			},

		],
		series: [
			{
				name: '来料信息',
				type: 'bar',
				label: {
					normal: {
						show: true,
						position: 'top',
						color: 'black',
					}
				},
				data: map.aList,
				barWidth : 30,//柱图宽度

			},
			{
				name: '用料信息',
				type: 'bar',
				label: {
					normal: {
						show: true,
						position: 'top',
						color: 'black',
					}
				},
				data: map.bList,
				barWidth : 30,//柱图宽度
			},{
				name: '余料信息',
				type: 'bar',
				label: {
					normal: {
						show: true,
						position: 'bottom',
						color: 'black',
					}
				},
				data: map.cList,
				barWidth : 30,//柱图宽度
			}
		]
	};
	return option;
}

function setPeibiOption(list) {
	let peibiOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data: ['热料配比%']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value'
		},
		series: [
			{
				name: '热料配比%',
				type: 'line',
				data: list.yList8
			}
		]
	};
	return peibiOption;
}

function setYouShiBiOption(list){
	let youshibiOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data:['油石比']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value',
			name: '百分比(%)',
			position: 'left',
		},
		series: [
			{
				name:'油石比',
				type:'line',
				data:list.yList1
			}
		]
	};
	return youshibiOption;
}

function setTanPuLiChengOption(list){
	let tanPuLiChengOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data:['摊铺里程统计']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value',
			name: 'm',
			position: 'left',
		},
		series: [
			{
				name:'摊铺里程统计',
				type:'line',
				data:list.yList1
			}
		]
	};
	return tanPuLiChengOption;
}

function setTanPuSuDuOption(list){
	let tanPusuduOption = {
		/*title: {
			text: '折线图堆叠'
		},*/
		legend: {
			data:['摊铺速度统计']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value',
			name: 'm/min',
			position: 'left',
		},
		series: [
			{
				name:'摊铺速度统计',
				type:'line',
				data:list.yList1
			}
		]
	};
	return tanPusuduOption;
}

function setTanPuWenDuOption(list){
	let tanPuWenDuOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data:['温度1','温度2']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value',
			name: '摄氏度(°)',
			position: 'left',
		},
		series: [
			{
				name:'温度1',
				type:'line',
				data:list.yList1
			},
			{
				name:'温度2',
				type:'line',
				data:list.yList2
			}
		]
	};
	return tanPuWenDuOption;
}

function setTanPuLiXiDuOption(list){
	let tanPuLiXiDuOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data:['离析度']
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value',
			name: '摄氏度(°)',
			position: 'left',
		},
		series: [
			{
				name:'离析度',
				type:'line',
				data:list.yList1
			}
		]
	};
	return tanPuLiXiDuOption;
}


function setTongGuoVoOption(list){
	let tongGuoOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data:['料1','料2','料3','料4','料5','料6','粉用量','沥青用量'],
			
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value'
		},
		series: [
			{
				name:'料1',
				type:'line',
				data:list.yList1
			},
			{
				name:'料2',
				type:'line',
				data:list.yList2
			},
			{
				name:'料3',
				type:'line',
				data:list.yList3
			}
		]
	};
	return tongGuoOption;
}



function setPianChaVoOption(list){
	let pianChaOption = {
//		title: {
//			text: '折线图堆叠'
//		},
		legend: {
			data:['料1偏差','料2偏差','料3偏差','料4偏差','料5偏差','料6偏差','粉偏差','沥青偏差','通过率偏差4.75','通过率偏差2.36','通过率偏差0.075'],
			right:10
		},
		grid: {
			left: '3%',
			right: '4%',
			bottom: '3%',
			containLabel: true
		},
		toolbox: {
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				restore: {},
				saveAsImage: {},
				dataView:{}
			}
		},
		tooltip : {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		dataZoom: [
			{
				show: true,
				realtime: true,
				start: 0,
				end: 100
			},
			{
				type: 'inside',
				realtime: true,
				start: 0,
				end: 100
			}
		],
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: list.xList
		},
		yAxis: {
			type: 'value'
		},
		series: [
			{
				name:'料1偏差',
				type:'line',
				data:list.yList1
			},
			{
				name:'料2偏差',
				type:'line',
				data:list.yList2
			},
			{
				name:'料3偏差',
				type:'line',
				data:list.yList3
			},
			{
				name:'料4偏差',
				type:'line',
				data:list.yList4
			},
			{
				name:'料5偏差',
				type:'line',
				data:list.yList5
			},
			{
				name:'料6偏差',
				type:'line',
				data:list.yList6
			},
			{
				name:'粉偏差',
				type:'line',
				data:list.yList7
			},
			{
				name:'沥青偏差',
				type:'line',
				data:list.yList8
			},
			{
				name:'通过率偏差4.75',
				type:'line',
				data:list.yList9
			},
			{
				name:'通过率偏差2.36',
				type:'line',
				data:list.yList10
			},
			{
				name:'通过率偏差0.075',
				type:'line',
				data:list.yList11
			}
		]
	};
	return pianChaOption;
}
