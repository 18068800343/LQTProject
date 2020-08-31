function getDay(day){
    var today = new Date();
    var targetday_milliseconds=today.getTime() + 1000*60*60*24*day;
    today.setTime(targetday_milliseconds); //注意，这行是关键代码
    var tYear = today.getFullYear();
    var tMonth = today.getMonth();
    var tDate = today.getDate();
    tMonth = doHandleMonth(tMonth + 1);
    tDate = doHandleMonth(tDate);
    tDate2 = doHandleMonth(tDate+1);
    var start= tYear+"-"+tMonth+"-"+tDate+" 00:00:00";
    var end= tYear+"-"+tMonth+"-"+tDate2+" 00:00:00";
    if(day!=0&&day!=-1){
        tDate = doHandleMonth(tDate + 1);
        start= tYear+"-"+tMonth+"-"+tDate+" 00:00:00";
        var myDate = new Date;
        var year = myDate.getFullYear(); //获取当前年
        var mon = doHandleMonth(myDate.getMonth() + 1); //获取当前月
        var date = doHandleMonth(myDate.getDate()); //获取当前日
        var date2 = doHandleMonth(myDate.getDate()+1); //获取当前日
        end=year+"-"+mon+"-"+date2+" 00:00:00";
    }
    $("#starTime").val(start)
    $("#endTime").val(end)

}
function doHandleMonth(month){
    var m = month;
    if(month.toString().length == 1){
        m = "0" + month;
    }
    return m;
}

//时间转化为毫秒
function getHaomiao(time){
    var startDate= time.replace(new RegExp("-","gm"),"/");
    var startDateM = (new Date(startDate)).getTime();
    return startDateM;
}

//经纬度校准
function gpsToBaidu(lonx, laty) {
    let p = wgs2bd(lonx, laty);
    return new BMap.Point(p[1], p[0]);
}


//return new Array(lon,lat) p[0],p[1]
function wgs2bd(lon,lat) {
    let wgs2gcjarr = wgs2gcj(lat, lon);
    let gcj2bdarr = gcj2bd(wgs2gcjarr[0], wgs2gcjarr[1]);
    return gcj2bdarr;
}



function gcj2bd(lat, lon) {
    let x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    let x = lon,
        y = lat;
    let z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
    let theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
    let bd_lon = z * Math.cos(theta) + 0.0065;
    let bd_lat = z * Math.sin(theta) + 0.006;
    return new Array(bd_lat, bd_lon);
}

function transformLat(lat, lon) {
    let pi = 3.14159265358979324;
    let ret = -100.0 + 2.0 * lat + 3.0 * lon + 0.2 * lon * lon + 0.1 * lat * lon + 0.2 * Math.sqrt(Math.abs(lat));
    ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
    ret += (20.0 * Math.sin(lon * pi) + 40.0 * Math.sin(lon / 3.0 * pi)) * 2.0 / 3.0;
    ret += (160.0 * Math.sin(lon / 12.0 * pi) + 320 * Math.sin(lon * pi / 30.0)) * 2.0 / 3.0;
    return ret;
}

function transformLon(lat, lon) {
    let pi = 3.14159265358979324;
    let ret = 300.0 + lat + 2.0 * lon + 0.1 * lat * lat + 0.1 * lat * lon + 0.1 * Math.sqrt(Math.abs(lat));
    ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
    ret += (20.0 * Math.sin(lat * pi) + 40.0 * Math.sin(lat / 3.0 * pi)) * 2.0 / 3.0;
    ret += (150.0 * Math.sin(lat / 12.0 * pi) + 300.0 * Math.sin(lat / 30.0 * pi)) * 2.0 / 3.0;
    return ret;
}

function wgs2gcj(lat, lon) {
    let pi = 3.14159265358979324;
    let a = 6378245.0;
    let ee = 0.00669342162296594323;
    let dLat = transformLat(lon - 105.0, lat - 35.0);
    let dLon = transformLon(lon - 105.0, lat - 35.0);
    let radLat = lat / 180.0 * pi;
    let magic = Math.sin(radLat);
    magic = 1 - ee * magic * magic;
    let sqrtMagic = Math.sqrt(magic);
    dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
    dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
    let mgLat = lat + dLat;
    let mgLon = lon + dLon;
    let loc = new Array(mgLat, mgLon);
    return loc;
}


