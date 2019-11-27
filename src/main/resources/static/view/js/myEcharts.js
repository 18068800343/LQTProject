let cangChuPosList = [
	'left', 'right', 'top', 'bottom',
	'inside',
	'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
	'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
];

function setCangChuConfigParameters(echartsDom){
	echartsDom.configParameters = {
		rotate: {
			min: -90,
			max: 90
		},
		align: {
			options: {
				left: 'left',
				center: 'center',
				right: 'right'
			}
		},
		verticalAlign: {
			options: {
				top: 'top',
				middle: 'middle',
				bottom: 'bottom'
			}
		},
		position: {
			options: echarts.util.reduce(cangChuPosList, function (map, pos) {
				map[pos] = pos;
				return map;
			}, {})
		},
		distance: {
			min: 0,
			max: 100
		}
	};

}

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
			fontSize: 16,
			rich: {
				name: {
					textBorderColor: '#fff'
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
