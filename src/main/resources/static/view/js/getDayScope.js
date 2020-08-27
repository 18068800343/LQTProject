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
