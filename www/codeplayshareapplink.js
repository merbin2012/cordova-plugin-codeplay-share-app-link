var exec = require('cordova/exec');


exports.shareWithContact = function (arg0,arg1,success, error) {
	exec(success, error, 'codeplayshareapplink', 'shareWithContact',[arg0,arg1]);
};