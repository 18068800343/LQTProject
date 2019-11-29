
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
			position: echartsDom.config.position,
			distance: echartsDom.config.distance,
			align: echartsDom.config.align,
			verticalAlign: echartsDom.config.verticalAlign,
			rotate: echartsDom.config.rotate,
			formatter: '{c}  {name|{a}}',
			fontSize: 30,
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
			color: ['#585858', '#006699'],
			tooltip: {
				trigger: 'axis',
				axisPointer: {
					type: 'shadow'
				}
			},
			legend: {
				data: ['仓库容量', '剩余重量']
			},
			toolbox: {
				show: true,
				orient: 'vertical',
				left: 'right',
				top: 'center',
				feature: {
					mark: {show: true},
					dataView: {show: true, readOnly: false},
					magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
					restore: {show: true},
					saveAsImage: {show: true}
				}
			},
			calculable: true,
			xAxis: [
				{
					type: 'category',
					name: '仓库编号',
					axisTick: {show: true},
					data: map.xList
				}
			],
			yAxis: [
				{
					type: 'value',
					name:"重量",
				}
			],
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

function setPeibiOption(list){
	let peibiOption = {
		title: {
			text: '折线图堆叠'
		},
		legend: {
			data:['料1','料2','料3','料4','料5','料6','粉用量','沥青用量']
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
			},
			{
				name:'料4',
				type:'line',
				data:list.yList4
			},
			{
				name:'料5',
				type:'line',
				data:list.yList5
			},
			{
				name:'料6',
				type:'line',
				data:list.yList6
			},
			{
				name:'粉用量',
				type:'line',
				data:list.yList7
			},
			{
				name:'沥青用量',
				type:'line',
				data:list.yList8
			}
		]
	};
	return peibiOption;
}


function setTongGuoVoOption(list){
	let tongGuoOption = {
		title: {
			text: '折线图堆叠'
		},
		legend: {
			data:['料1','料2','料3','料4','料5','料6','粉用量','沥青用量']
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
