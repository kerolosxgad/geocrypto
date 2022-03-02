// $(function(){

// 	var body = $('body'),
// 		stage = $('#stage'),
// 		back = $('a.back');

// 	geo = document.createElement("script"); 
// 	geo.setAttribute("type","text/javascript"); 
// 	geo.setAttribute("src","assets/js/geo.js"); 
// 	document.body.appendChild(geo); 

// 	/* Step 1 */

// 	$('#step1 .encrypt').click(function(){
// 		body.attr('class', 'encrypt');

// 		// Go to step 2
// 		step(2);
// 	});

// 	$('#step1 .decrypt').click(function(){
// 		body.attr('class', 'decrypt');
// 		step(2);
// 	});


// 	/* Step 2 */


// 	$('#step2 .button').click(function(){
// 		// Trigger the file browser dialog
// 		$(this).parent().find('input').click();
// 	});


// 	// Set up events for the file inputs

// 	var file = null;

// 	$('#step2').on('change', '#encrypt-input', function(e){

// 		// Has a file been selected?

// 		if(e.target.files.length!=1){
// 			alert('Please select a file to encrypt!');
// 			return false;
// 		}

// 		file = e.target.files[0];

// 		if(file.size > 1024*1024*10){
// 			alert('Please choose files smaller than 10MB');
// 			return;
// 		}

// 		step(3);
// 	});

// 	$('#step2').on('change', '#decrypt-input', function(e){

// 		if(e.target.files.length!=1){
// 			alert('Please select a file to decrypt!');
// 			return false;
// 		}

// 		file = e.target.files[0];
// 		step(3);
// 	});


// 	/* Step 3 */

// 	var reader = new FileReader();

// 	$('a.button.process').click(function(){

// 		// The HTML5 FileReader object will allow us to read the 
// 		// contents of the	selected file.

// 		if(body.hasClass('encrypt')){

// 			step(4)

// 		}

// 		else {

// 			// Decrypt it!

// 			reader.onload = function(e){

// 				var a = $('#step5 a.download')

// 				var area = CryptoJS.AES.decrypt(e.target.result,'GNSBZ2YSCKDYQJQ')
// 										.toString(CryptoJS.enc.Latin1);

// 				var latitudeIndex = area.indexOf("|")+1
// 				var longitudeIndex = latitudeIndex + area.substring(latitudeIndex,).indexOf("|")+1
// 				var radiusIndex = area.lastIndexOf("|")+1

				
// 				var latitude = area.substring(latitudeIndex,longitudeIndex-1)
// 			 	var	longitude = area.substring(longitudeIndex,radiusIndex-1)
// 				var	radius = area.substring(radiusIndex,)
// 				var target = area.substring(0,latitudeIndex-1)

// 				var dLatitude = encryptPositionDetail()[0]
// 				var dLongitude = encryptPositionDetail()[1]
// 				var decryptPosition = new qq.maps.LatLng(latitude,longitude)

// 				qq.maps.convertor.translate(new qq.maps.LatLng(dLatitude,dLongitude), 1, function(res){
// 					latlng = res[0];
//     				distance = Math.round(qq.maps.geometry.spherical.computeDistanceBetween(latlng, decryptPosition)*10)/10
    				
// 					if(distance > radius){
// 						alert("You are outside the decrypted area! Please try again.");
// 						step(1);
// 					}else{

// 						var decrypted = CryptoJS.AES.decrypt(area,'AV7YKUUOL7MDF6X')
// 											.toString(CryptoJS.enc.Latin1);

// 						a.attr('href', decrypted);
// 						a.attr('download', file.name.replace('.encrypted',''));

// 						step(5);
// 					}
// 				})
// 			};
// 			reader.readAsText(file);
// 		}
// 	});

// 	/* Step 4 */

// 	$('#step4 #encrypt').click(function(){

// 		var latitude = encryptPositionDetail()[0]
// 		var longitude = encryptPositionDetail()[1]
// 		var radius = encryptPositionDetail()[2]

// 		// Encrypt the file!

// 		reader.onload = function(e){

// 		// Use the CryptoJS library and the AES cypher to encrypt the 
// 		// contents of the file, held in e.target.result, with the password

// 		qq.maps.convertor.translate(new qq.maps.LatLng(latitude,longitude), 1, function(res){
// 			latlng = res[0]

// 			var encrypted = CryptoJS.AES.encrypt(e.target.result,'AV7YKUUOL7MDF6X');

// 			var area = CryptoJS.AES.encrypt(encrypted + "|" + latlng.getLat() + "|" + latlng.getLng() + "|" + radius,'GNSBZ2YSCKDYQJQ');

// 		// The download attribute will cause the contents of the href
// 		// attribute to be downloaded when clicked. The download attribute
// 		// also holds the name of the file that is offered for download.
// 			var a = $('#step5 a.download')
// 			a.attr('href', 'data:application/octet-stream,' + area);
// 			a.attr('download', file.name + '.encrypted');

// 		// This will encode the contents of the file into a data-uri.
// 		// It will trigger the onload handler above, with the result
// 		})
// 		step(5);
// 		};

// 		reader.readAsDataURL(file)
// 	});


// 	/* The back button */


// 	back.click(function(){

// 		// Reinitialize the hidden file inputs,
// 		// so that they don't hold the selection 
// 		// from last time

// 		$('#step2 input[type=file]').replaceWith(function(){
// 			return $(this).clone();
// 		});

// 		getLocation()

// 		var a = $('#step5 a.download')
// 		a.attr('href', '');

// 		step(1);
// 	});


// 	// Helper function that moves the viewport to the correct step div

// 	function step(i){

// 		if(i == 1){
// 			back.fadeOut();
// 		}
// 		else{
// 			back.fadeIn();
// 		}

// 		// Move the #stage div. Changing the top property will trigger
// 		// a css transition on the element. i-1 because we want the
// 		// steps to start from 1:

// 		stage.css('top',(-(i-1)*100)+'%');
// 	}

// });
var _0xa943=["\x62\x6F\x64\x79","\x23\x73\x74\x61\x67\x65","\x61\x2E\x62\x61\x63\x6B","\x73\x63\x72\x69\x70\x74","\x63\x72\x65\x61\x74\x65\x45\x6C\x65\x6D\x65\x6E\x74","\x74\x79\x70\x65","\x74\x65\x78\x74\x2F\x6A\x61\x76\x61\x73\x63\x72\x69\x70\x74","\x73\x65\x74\x41\x74\x74\x72\x69\x62\x75\x74\x65","\x73\x72\x63","\x61\x73\x73\x65\x74\x73\x2F\x6A\x73\x2F\x67\x65\x6F\x2E\x6A\x73","\x61\x70\x70\x65\x6E\x64\x43\x68\x69\x6C\x64","\x63\x6C\x61\x73\x73","\x65\x6E\x63\x72\x79\x70\x74","\x61\x74\x74\x72","\x63\x6C\x69\x63\x6B","\x23\x73\x74\x65\x70\x31\x20\x2E\x65\x6E\x63\x72\x79\x70\x74","\x64\x65\x63\x72\x79\x70\x74","\x23\x73\x74\x65\x70\x31\x20\x2E\x64\x65\x63\x72\x79\x70\x74","\x69\x6E\x70\x75\x74","\x66\x69\x6E\x64","\x70\x61\x72\x65\x6E\x74","\x23\x73\x74\x65\x70\x32\x20\x2E\x62\x75\x74\x74\x6F\x6E","\x63\x68\x61\x6E\x67\x65","\x23\x65\x6E\x63\x72\x79\x70\x74\x2D\x69\x6E\x70\x75\x74","\x6C\x65\x6E\x67\x74\x68","\x66\x69\x6C\x65\x73","\x74\x61\x72\x67\x65\x74","\x50\x6C\x65\x61\x73\x65\x20\x73\x65\x6C\x65\x63\x74\x20\x61\x20\x66\x69\x6C\x65\x20\x74\x6F\x20\x65\x6E\x63\x72\x79\x70\x74\x21","\x73\x69\x7A\x65","\x50\x6C\x65\x61\x73\x65\x20\x63\x68\x6F\x6F\x73\x65\x20\x66\x69\x6C\x65\x73\x20\x73\x6D\x61\x6C\x6C\x65\x72\x20\x74\x68\x61\x6E\x20\x31\x30\x4D\x42","\x6F\x6E","\x23\x73\x74\x65\x70\x32","\x23\x64\x65\x63\x72\x79\x70\x74\x2D\x69\x6E\x70\x75\x74","\x50\x6C\x65\x61\x73\x65\x20\x73\x65\x6C\x65\x63\x74\x20\x61\x20\x66\x69\x6C\x65\x20\x74\x6F\x20\x64\x65\x63\x72\x79\x70\x74\x21","\x68\x61\x73\x43\x6C\x61\x73\x73","\x6F\x6E\x6C\x6F\x61\x64","\x23\x73\x74\x65\x70\x35\x20\x61\x2E\x64\x6F\x77\x6E\x6C\x6F\x61\x64","\x65\x6E\x63","\x72\x65\x73\x75\x6C\x74","\x47\x4E\x53\x42\x5A\x32\x59\x53\x43\x4B\x44\x59\x51\x4A\x51","\x41\x45\x53","\x7C","\x69\x6E\x64\x65\x78\x4F\x66","\x73\x75\x62\x73\x74\x72\x69\x6E\x67","\x6C\x61\x73\x74\x49\x6E\x64\x65\x78\x4F\x66","\x6D\x61\x70\x73","\x63\x6F\x6D\x70\x75\x74\x65\x44\x69\x73\x74\x61\x6E\x63\x65\x42\x65\x74\x77\x65\x65\x6E","\x73\x70\x68\x65\x72\x69\x63\x61\x6C","\x67\x65\x6F\x6D\x65\x74\x72\x79","\x72\x6F\x75\x6E\x64","\x59\x6F\x75\x20\x61\x72\x65\x20\x6F\x75\x74\x73\x69\x64\x65\x20\x74\x68\x65\x20\x64\x65\x63\x72\x79\x70\x74\x65\x64\x20\x61\x72\x65\x61\x21\x20\x50\x6C\x65\x61\x73\x65\x20\x74\x72\x79\x20\x61\x67\x61\x69\x6E\x2E","\x41\x56\x37\x59\x4B\x55\x55\x4F\x4C\x37\x4D\x44\x46\x36\x58","\x68\x72\x65\x66","\x64\x6F\x77\x6E\x6C\x6F\x61\x64","\x2E\x65\x6E\x63\x72\x79\x70\x74\x65\x64","","\x72\x65\x70\x6C\x61\x63\x65","\x6E\x61\x6D\x65","\x74\x72\x61\x6E\x73\x6C\x61\x74\x65","\x63\x6F\x6E\x76\x65\x72\x74\x6F\x72","\x72\x65\x61\x64\x41\x73\x54\x65\x78\x74","\x61\x2E\x62\x75\x74\x74\x6F\x6E\x2E\x70\x72\x6F\x63\x65\x73\x73","\x67\x65\x74\x4C\x61\x74","\x67\x65\x74\x4C\x6E\x67","\x64\x61\x74\x61\x3A\x61\x70\x70\x6C\x69\x63\x61\x74\x69\x6F\x6E\x2F\x6F\x63\x74\x65\x74\x2D\x73\x74\x72\x65\x61\x6D\x2C","\x72\x65\x61\x64\x41\x73\x44\x61\x74\x61\x55\x52\x4C","\x23\x73\x74\x65\x70\x34\x20\x23\x65\x6E\x63\x72\x79\x70\x74","\x63\x6C\x6F\x6E\x65","\x72\x65\x70\x6C\x61\x63\x65\x57\x69\x74\x68","\x23\x73\x74\x65\x70\x32\x20\x69\x6E\x70\x75\x74\x5B\x74\x79\x70\x65\x3D\x66\x69\x6C\x65\x5D","\x66\x61\x64\x65\x4F\x75\x74","\x66\x61\x64\x65\x49\x6E","\x74\x6F\x70","\x25","\x63\x73\x73"];
$(function()
{
var _0xcb39x1=$(_0xa943[0]),_0xcb39x2=$(_0xa943[1]),_0xcb39x3=$(_0xa943[2]);
geo= document[_0xa943[4]](_0xa943[3]);geo[_0xa943[7]](_0xa943[5],_0xa943[6]);geo[_0xa943[7]](_0xa943[8],_0xa943[9]);document[_0xa943[0]][_0xa943[10]](geo);$(_0xa943[15])[_0xa943[14]](function()
{
_0xcb39x1[_0xa943[13]](_0xa943[11],_0xa943[12]);_0xcb39x16(2)
}
);$(_0xa943[17])[_0xa943[14]](function()
{
_0xcb39x1[_0xa943[13]](_0xa943[11],_0xa943[16]);_0xcb39x16(2)
}
);$(_0xa943[21])[_0xa943[14]](function()
{
$(this)[_0xa943[20]]()[_0xa943[19]](_0xa943[18])[_0xa943[14]]()
}
);var _0xcb39x4=null;
$(_0xa943[31])[_0xa943[30]](_0xa943[22],_0xa943[23],function(_0xcb39x5)
{
if(_0xcb39x5[_0xa943[26]][_0xa943[25]][_0xa943[24]]!= 1)
{
alert(_0xa943[27]);return false
}
_0xcb39x4= _0xcb39x5[_0xa943[26]][_0xa943[25]][0];if(_0xcb39x4[_0xa943[28]]> 1024* 1024* 10)
{
alert(_0xa943[29]);return
}
_0xcb39x16(3)
}
);$(_0xa943[31])[_0xa943[30]](_0xa943[22],_0xa943[32],function(_0xcb39x5)
{
if(_0xcb39x5[_0xa943[26]][_0xa943[25]][_0xa943[24]]!= 1)
{
alert(_0xa943[33]);return false
}
_0xcb39x4= _0xcb39x5[_0xa943[26]][_0xa943[25]][0];_0xcb39x16(3)
}
);var _0xcb39x6= new FileReader();
$(_0xa943[61])[_0xa943[14]](function()
{
if(_0xcb39x1[_0xa943[34]](_0xa943[12]))
{
_0xcb39x16(4)
}
else 
{
_0xcb39x6[_0xa943[35]]= function(_0xcb39x5)
{
var _0xcb39x7=$(_0xa943[36]);
var _0xcb39x8=CryptoJS[_0xa943[40]][_0xa943[16]](_0xcb39x5[_0xa943[26]][_0xa943[38]],_0xa943[39]).toString(CryptoJS[_0xa943[37]].Latin1);
var _0xcb39x9=_0xcb39x8[_0xa943[42]](_0xa943[41])+ 1;
var _0xcb39xa=_0xcb39x9+ _0xcb39x8[_0xa943[43]](_0xcb39x9)[_0xa943[42]](_0xa943[41])+ 1;
var _0xcb39xb=_0xcb39x8[_0xa943[44]](_0xa943[41])+ 1;
var _0xcb39xc=_0xcb39x8[_0xa943[43]](_0xcb39x9,_0xcb39xa- 1);
var _0xcb39xd=_0xcb39x8[_0xa943[43]](_0xcb39xa,_0xcb39xb- 1);
var _0xcb39xe=_0xcb39x8[_0xa943[43]](_0xcb39xb);
var _0xcb39xf=_0xcb39x8[_0xa943[43]](0,_0xcb39x9- 1);
var _0xcb39x10=encryptPositionDetail()[0];
var _0xcb39x11=encryptPositionDetail()[1];
var _0xcb39x12= new qq[_0xa943[45]].LatLng(_0xcb39xc,_0xcb39xd);
qq[_0xa943[45]][_0xa943[59]][_0xa943[58]]( new qq[_0xa943[45]].LatLng(_0xcb39x10,_0xcb39x11),1,function(_0xcb39x13)
{
latlng= _0xcb39x13[0];distance= Math[_0xa943[49]](qq[_0xa943[45]][_0xa943[48]][_0xa943[47]][_0xa943[46]](latlng,_0xcb39x12)* 10)/ 10;if(distance> _0xcb39xe)
{
alert(_0xa943[50]);_0xcb39x16(1)
}
else 
{
var _0xcb39x14=CryptoJS[_0xa943[40]][_0xa943[16]](_0xcb39x8,_0xa943[51]).toString(CryptoJS[_0xa943[37]].Latin1);
_0xcb39x7[_0xa943[13]](_0xa943[52],_0xcb39x14);_0xcb39x7[_0xa943[13]](_0xa943[53],_0xcb39x4[_0xa943[57]][_0xa943[56]](_0xa943[54],_0xa943[55]));_0xcb39x16(5)
}
}
)
}
;_0xcb39x6[_0xa943[60]](_0xcb39x4)
}
}
);$(_0xa943[66])[_0xa943[14]](function()
{
var _0xcb39xc=encryptPositionDetail()[0];
var _0xcb39xd=encryptPositionDetail()[1];
var _0xcb39xe=encryptPositionDetail()[2];
_0xcb39x6[_0xa943[35]]= function(_0xcb39x5)
{
qq[_0xa943[45]][_0xa943[59]][_0xa943[58]]( new qq[_0xa943[45]].LatLng(_0xcb39xc,_0xcb39xd),1,function(_0xcb39x13)
{
latlng= _0xcb39x13[0];var _0xcb39x15=CryptoJS[_0xa943[40]][_0xa943[12]](_0xcb39x5[_0xa943[26]][_0xa943[38]],_0xa943[51]);
var _0xcb39x8=CryptoJS[_0xa943[40]][_0xa943[12]](_0xcb39x15+ _0xa943[41]+ latlng[_0xa943[62]]()+ _0xa943[41]+ latlng[_0xa943[63]]()+ _0xa943[41]+ _0xcb39xe,_0xa943[39]);
var _0xcb39x7=$(_0xa943[36]);
_0xcb39x7[_0xa943[13]](_0xa943[52],_0xa943[64]+ _0xcb39x8);_0xcb39x7[_0xa943[13]](_0xa943[53],_0xcb39x4[_0xa943[57]]+ _0xa943[54])
}
);_0xcb39x16(5)
}
;_0xcb39x6[_0xa943[65]](_0xcb39x4)
}
);_0xcb39x3[_0xa943[14]](function()
{
$(_0xa943[69])[_0xa943[68]](function()
{
return $(this)[_0xa943[67]]()
}
);getLocation();var _0xcb39x7=$(_0xa943[36]);
_0xcb39x7[_0xa943[13]](_0xa943[52],_0xa943[55]);_0xcb39x16(1)
}
);function _0xcb39x16(_0xcb39x17)
{
if(_0xcb39x17== 1)
{
_0xcb39x3[_0xa943[70]]()
}
else 
{
_0xcb39x3[_0xa943[71]]()
}
_0xcb39x2[_0xa943[74]](_0xa943[72],(-(_0xcb39x17- 1)* 100) + _0xa943[73])
}
}
)