// function getLocation(){ 
// 	if (navigator.geolocation){ 
// 		navigator.geolocation.getCurrentPosition(getPosition,showError); 
// 	}else{ 
// 		alert("浏览器不支持地理定位。"); 
// 	} 
// } 

// function showError(error){ 
// 	switch(error.code) { 
// 		case error.PERMISSION_DENIED: 
// 			alert("定位失败,用户拒绝请求地理定位"); 
// 		break; 
		
// 		case error.POSITION_UNAVAILABLE: 
// 			alert("定位失败,位置信息是不可用"); 
// 		break; 

// 		case error.TIMEOUT: 
// 			alert("定位失败,请求获取用户位置超时"); 
// 		break;

// 		case error.UNKNOWN_ERROR: 
// 			alert("定位失败,定位系统失效"); 
// 		break; 
// 	} 
// } 

// var latitude //纬度 
// var longitude //经度 
// var radius = 25
// var distance
// var geocoder,map,marker,circle = null

// function getPosition(position){
// 	latitude = position.coords.latitude.toFixed(6);
// 	longitude = position.coords.longitude.toFixed(6);
// }

// function showMap(){ 

// 	document.getElementById("map").style.display="";
// 	qq.maps.convertor.translate(new qq.maps.LatLng(latitude,longitude), 1, function(res){
// 		latlng = res[0];

// 		map = new qq.maps.Map(document.getElementById("map"), {
//             	center: latlng,
//             	zoom:15         
//     	});

//     	marker = new qq.maps.Marker({
//        		position: latlng,
//        		animation:qq.maps.MarkerAnimation.DROP,
//         	map: map
//     	});

//     	circle = new qq.maps.Circle({
//         	map:map,
//         	center:latlng,
//         	radius:radius,
//         	fillColor: new qq.maps.Color(0,0,0,0.3),
//         	strokeWeight:0
//     	});

//     	geocoder = new qq.maps.Geocoder({
//         	complete : function(result){
//         		marker.setMap(null)
//     			circle.setMap(null)

//             	map.setCenter(result.detail.location);
//             	marker = new qq.maps.Marker({
//                 	map:map,
//                 	position: result.detail.location
//             	});
//             	circle = new qq.maps.Circle({
//             		map:map,
//         			center:result.detail.location,
//         			radius:radius,
//         			fillColor: new qq.maps.Color(0,0,0,0.3),
//         			strokeWeight:0
//     				});
//             	latitude = result.detail.location.getLat().toFixed(6)
//         		longitude = result.detail.location.getLng().toFixed(6)
//         	}
//     	});

//     	qq.maps.event.addListener(map, 'click', function(event) {
//     		marker.setMap(null)
//     		circle.setMap(null)

//         	latitude = event.latLng.getLat().toFixed(6)
//         	longitude = event.latLng.getLng().toFixed(6)
    		
//     		marker = new qq.maps.Marker({
//        			position: event.latLng,
//        			animation:qq.maps.MarkerAnimation.DROP,
//         		map: map
//     		});

//     		circle = new qq.maps.Circle({
//             		map:map,
//         			center:event.latLng,
//         			radius:radius,
//         			fillColor: new qq.maps.Color(0,0,0,0.3),
//         			strokeWeight:0
//     		});
//     	});

// 		var plus=document.getElementById("plus");
//     	qq.maps.event.addDomListener(plus,"click",function(){
//         	circle.setMap(map);
//         	if(circle.getRadius()+100>1025){
//             	circle.setRadius(1025);
//             	radius = circle.getRadius()
//             	alert("The area which can decrypt file is too large to be safe, no more than 1025 meters")
//         	}else{
//             	circle.setRadius(circle.getRadius()+100);
//             	radius = circle.getRadius()
//         	}
//     	});

//     	var minus=document.getElementById("minus");
//     	qq.maps.event.addDomListener(minus,"click",function(){
//         	circle.setMap(map);
//         	if(circle.getRadius()-100<25){
//             	circle.setRadius(25);
//             	radius = circle.getRadius()
//             	alert("The area which can decrypt file is too small to ignore deviation, no less than 25 meters")
//         	}else{
//             	circle.setRadius(circle.getRadius()-100);
//             	radius = circle.getRadius()
//         	}
//     	});
//     });
// } 

// function codeAddress() {
//     var address = document.getElementById("address").value;
//     //通过getLocation();方法获取位置信息值
//     geocoder.getLocation(address);
// }

// function geometry(dLatitude,dLongitude,dRadius){
	
// 	var decryptPosition = new qq.maps.LatLng(dLatitude,dLongitude)

// 	qq.maps.convertor.translate(new qq.maps.LatLng(latitude,longitude), 1, function(res){
// 		latlng = res[0];
//     	distance = Math.round(qq.maps.geometry.spherical.computeDistanceBetween(latlng, decryptPosition)*10)/10
// 	})
// 	return distance
// }

// function encryptPositionDetail(){
// 	return [latitude,longitude,radius]
// }

// function hideMap(){
//      document.getElementById("map").style.display="none";
// }
var _0xa28f=["\x67\x65\x6F\x6C\x6F\x63\x61\x74\x69\x6F\x6E","\x67\x65\x74\x43\x75\x72\x72\x65\x6E\x74\x50\x6F\x73\x69\x74\x69\x6F\x6E","\u6D4F\u89C8\u5668\u4E0D\u652F\u6301\u5730\u7406\u5B9A\u4F4D\u3002","\u5B9A\u4F4D\u5931\u8D25\x2C\u7528\u6237\u62D2\u7EDD\u8BF7\u6C42\u5730\u7406\u5B9A\u4F4D","\x50\x45\x52\x4D\x49\x53\x53\x49\x4F\x4E\x5F\x44\x45\x4E\x49\x45\x44","\u5B9A\u4F4D\u5931\u8D25\x2C\u4F4D\u7F6E\u4FE1\u606F\u662F\u4E0D\u53EF\u7528","\x50\x4F\x53\x49\x54\x49\x4F\x4E\x5F\x55\x4E\x41\x56\x41\x49\x4C\x41\x42\x4C\x45","\u5B9A\u4F4D\u5931\u8D25\x2C\u8BF7\u6C42\u83B7\u53D6\u7528\u6237\u4F4D\u7F6E\u8D85\u65F6","\x54\x49\x4D\x45\x4F\x55\x54","\u5B9A\u4F4D\u5931\u8D25\x2C\u5B9A\u4F4D\u7CFB\u7EDF\u5931\u6548","\x55\x4E\x4B\x4E\x4F\x57\x4E\x5F\x45\x52\x52\x4F\x52","\x63\x6F\x64\x65","\x74\x6F\x46\x69\x78\x65\x64","\x6C\x61\x74\x69\x74\x75\x64\x65","\x63\x6F\x6F\x72\x64\x73","\x6C\x6F\x6E\x67\x69\x74\x75\x64\x65","\x64\x69\x73\x70\x6C\x61\x79","\x73\x74\x79\x6C\x65","\x6D\x61\x70","\x67\x65\x74\x45\x6C\x65\x6D\x65\x6E\x74\x42\x79\x49\x64","","\x6D\x61\x70\x73","\x44\x52\x4F\x50","\x4D\x61\x72\x6B\x65\x72\x41\x6E\x69\x6D\x61\x74\x69\x6F\x6E","\x73\x65\x74\x4D\x61\x70","\x6C\x6F\x63\x61\x74\x69\x6F\x6E","\x64\x65\x74\x61\x69\x6C","\x73\x65\x74\x43\x65\x6E\x74\x65\x72","\x67\x65\x74\x4C\x61\x74","\x67\x65\x74\x4C\x6E\x67","\x63\x6C\x69\x63\x6B","\x6C\x61\x74\x4C\x6E\x67","\x61\x64\x64\x4C\x69\x73\x74\x65\x6E\x65\x72","\x65\x76\x65\x6E\x74","\x70\x6C\x75\x73","\x67\x65\x74\x52\x61\x64\x69\x75\x73","\x73\x65\x74\x52\x61\x64\x69\x75\x73","\x54\x68\x65\x20\x61\x72\x65\x61\x20\x77\x68\x69\x63\x68\x20\x63\x61\x6E\x20\x64\x65\x63\x72\x79\x70\x74\x20\x66\x69\x6C\x65\x20\x69\x73\x20\x74\x6F\x6F\x20\x6C\x61\x72\x67\x65\x20\x74\x6F\x20\x62\x65\x20\x73\x61\x66\x65\x2C\x20\x6E\x6F\x20\x6D\x6F\x72\x65\x20\x74\x68\x61\x6E\x20\x31\x30\x32\x35\x20\x6D\x65\x74\x65\x72\x73","\x61\x64\x64\x44\x6F\x6D\x4C\x69\x73\x74\x65\x6E\x65\x72","\x6D\x69\x6E\x75\x73","\x54\x68\x65\x20\x61\x72\x65\x61\x20\x77\x68\x69\x63\x68\x20\x63\x61\x6E\x20\x64\x65\x63\x72\x79\x70\x74\x20\x66\x69\x6C\x65\x20\x69\x73\x20\x74\x6F\x6F\x20\x73\x6D\x61\x6C\x6C\x20\x74\x6F\x20\x69\x67\x6E\x6F\x72\x65\x20\x64\x65\x76\x69\x61\x74\x69\x6F\x6E\x2C\x20\x6E\x6F\x20\x6C\x65\x73\x73\x20\x74\x68\x61\x6E\x20\x32\x35\x20\x6D\x65\x74\x65\x72\x73","\x74\x72\x61\x6E\x73\x6C\x61\x74\x65","\x63\x6F\x6E\x76\x65\x72\x74\x6F\x72","\x76\x61\x6C\x75\x65","\x61\x64\x64\x72\x65\x73\x73","\x67\x65\x74\x4C\x6F\x63\x61\x74\x69\x6F\x6E","\x63\x6F\x6D\x70\x75\x74\x65\x44\x69\x73\x74\x61\x6E\x63\x65\x42\x65\x74\x77\x65\x65\x6E","\x73\x70\x68\x65\x72\x69\x63\x61\x6C","\x67\x65\x6F\x6D\x65\x74\x72\x79","\x72\x6F\x75\x6E\x64","\x6E\x6F\x6E\x65"];
function getLocation()
{
if(navigator[_0xa28f[0]])
{
navigator[_0xa28f[0]][_0xa28f[1]](getPosition,showError)
}
else 
{
alert(_0xa28f[2])
}
}
function showError(_0x3b7cx3)
{
switch(_0x3b7cx3[_0xa28f[11]])
{
case _0x3b7cx3[_0xa28f[4]]:alert(_0xa28f[3]);break
case _0x3b7cx3[_0xa28f[6]]:alert(_0xa28f[5]);break
case _0x3b7cx3[_0xa28f[8]]:alert(_0xa28f[7]);break
case _0x3b7cx3[_0xa28f[10]]:alert(_0xa28f[9]);break
}
}
var latitude;
var longitude;
var radius=25;
var distance;
var geocoder,map,marker,circle=null;
function getPosition(_0x3b7cxd)
{
latitude= _0x3b7cxd[_0xa28f[14]][_0xa28f[13]][_0xa28f[12]](6);longitude= _0x3b7cxd[_0xa28f[14]][_0xa28f[15]][_0xa28f[12]](6)
}
function showMap()
{
document[_0xa28f[19]](_0xa28f[18])[_0xa28f[17]][_0xa28f[16]]= _0xa28f[20];qq[_0xa28f[21]][_0xa28f[42]][_0xa28f[41]]( new qq[_0xa28f[21]].LatLng(latitude,longitude),1,function(_0x3b7cxf)
{
latlng= _0x3b7cxf[0];map=  new qq[_0xa28f[21]].Map(document[_0xa28f[19]](_0xa28f[18]),{center:latlng,zoom:15});marker=  new qq[_0xa28f[21]].Marker({position:latlng,animation:qq[_0xa28f[21]][_0xa28f[23]][_0xa28f[22]],map:map});circle=  new qq[_0xa28f[21]].Circle({map:map,center:latlng,radius:radius,fillColor: new qq[_0xa28f[21]].Color(0,0,0,0.3),strokeWeight:0});geocoder=  new qq[_0xa28f[21]].Geocoder({complete:function(_0x3b7cx10)
{
marker[_0xa28f[24]](null);circle[_0xa28f[24]](null);map[_0xa28f[27]](_0x3b7cx10[_0xa28f[26]][_0xa28f[25]]);marker=  new qq[_0xa28f[21]].Marker({map:map,position:_0x3b7cx10[_0xa28f[26]][_0xa28f[25]]});circle=  new qq[_0xa28f[21]].Circle({map:map,center:_0x3b7cx10[_0xa28f[26]][_0xa28f[25]],radius:radius,fillColor: new qq[_0xa28f[21]].Color(0,0,0,0.3),strokeWeight:0});latitude= _0x3b7cx10[_0xa28f[26]][_0xa28f[25]][_0xa28f[28]]()[_0xa28f[12]](6);longitude= _0x3b7cx10[_0xa28f[26]][_0xa28f[25]][_0xa28f[29]]()[_0xa28f[12]](6)
}
});qq[_0xa28f[21]][_0xa28f[33]][_0xa28f[32]](map,_0xa28f[30],function(_0x3b7cx11)
{
marker[_0xa28f[24]](null);circle[_0xa28f[24]](null);latitude= _0x3b7cx11[_0xa28f[31]][_0xa28f[28]]()[_0xa28f[12]](6);longitude= _0x3b7cx11[_0xa28f[31]][_0xa28f[29]]()[_0xa28f[12]](6);marker=  new qq[_0xa28f[21]].Marker({position:_0x3b7cx11[_0xa28f[31]],animation:qq[_0xa28f[21]][_0xa28f[23]][_0xa28f[22]],map:map});circle=  new qq[_0xa28f[21]].Circle({map:map,center:_0x3b7cx11[_0xa28f[31]],radius:radius,fillColor: new qq[_0xa28f[21]].Color(0,0,0,0.3),strokeWeight:0})
}
);var _0x3b7cx12=document[_0xa28f[19]](_0xa28f[34]);
qq[_0xa28f[21]][_0xa28f[33]][_0xa28f[38]](_0x3b7cx12,_0xa28f[30],function()
{
circle[_0xa28f[24]](map);if(circle[_0xa28f[35]]()+ 100> 1025)
{
circle[_0xa28f[36]](1025);radius= circle[_0xa28f[35]]();alert(_0xa28f[37])
}
else 
{
circle[_0xa28f[36]](circle[_0xa28f[35]]()+ 100);radius= circle[_0xa28f[35]]()
}
}
);var _0x3b7cx13=document[_0xa28f[19]](_0xa28f[39]);
qq[_0xa28f[21]][_0xa28f[33]][_0xa28f[38]](_0x3b7cx13,_0xa28f[30],function()
{
circle[_0xa28f[24]](map);if(circle[_0xa28f[35]]()- 100< 25)
{
circle[_0xa28f[36]](25);radius= circle[_0xa28f[35]]();alert(_0xa28f[40])
}
else 
{
circle[_0xa28f[36]](circle[_0xa28f[35]]()- 100);radius= circle[_0xa28f[35]]()
}
}
)
}
)
}
function codeAddress()
{
var _0x3b7cx15=document[_0xa28f[19]](_0xa28f[44])[_0xa28f[43]];
geocoder[_0xa28f[45]](_0x3b7cx15)
}
function geometry(_0x3b7cx17,_0x3b7cx18,_0x3b7cx19)
{
var _0x3b7cx1a= new qq[_0xa28f[21]].LatLng(_0x3b7cx17,_0x3b7cx18);
qq[_0xa28f[21]][_0xa28f[42]][_0xa28f[41]]( new qq[_0xa28f[21]].LatLng(latitude,longitude),1,function(_0x3b7cxf)
{
latlng= _0x3b7cxf[0];distance= Math[_0xa28f[49]](qq[_0xa28f[21]][_0xa28f[48]][_0xa28f[47]][_0xa28f[46]](latlng,_0x3b7cx1a)* 10)/ 10
}
);return distance
}
function encryptPositionDetail()
{
return [latitude,longitude,radius]
}
function hideMap()
{
document[_0xa28f[19]](_0xa28f[18])[_0xa28f[17]][_0xa28f[16]]= _0xa28f[50]
}

