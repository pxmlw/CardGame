

function email_check(giv_email){
     var EMAIL_REGEX = /^([^@\s]+)@((?:[-a-z0-9]+\.)+[a-z]{2,})$/i;
     var email_value = EMAIL_REGEX.test(giv_email); //return true or false
     return email_value;
}
function phone_no_check(giv_number){
     var PHONE_REGEX = /^[0-9]{10}$/;
     var phone_value = PHONE_REGEX.test(new String(giv_number)); //return true or false
     return phone_value;
}
function Pincode_check(giv_number){
     var PHONE_REGEX = /^[0-9]{6}$/;
     var phone_value = PHONE_REGEX.test(new String(giv_number)); //return true or false
     return phone_value;
}
function Age_check(giv_number){
     var PHONE_REGEX = /^[0-9]{1,2}$/;
     var phone_value = PHONE_REGEX.test(new String(giv_number)); //return true or false
     return phone_value;
}
function website_check(giv_website){
     var WEBSITE_REGEX = /^([a-z0-9_-]+\.)*[a-z0-9_-]+(\.[a-z]{2,6}){1,2}$/;
     var website_value = WEBSITE_REGEX.test(giv_website); //return true or false
     return website_value;
}
function string_name_and_number_check(giv_name){
     var NAME_REGEX = /^[A-Za-z0-9 ]{1,35}$/;
     var website_name_value = NAME_REGEX.test(giv_name); //return true or false
     return website_name_value;
}
function number_check(giv_name){
     var NAME_REGEX = /^[0-9 ]{1,35}$/;
     var website_name_value = NAME_REGEX.test(giv_name); //return true or false
     return website_name_value;
}

function string_check(giv_str){
     var STRING_REGEX = /^[A-Za-z ]{3,35}$/;
     var string_value = STRING_REGEX.test(giv_str);
     return string_value;
}
function dateValidation(givStr){
     var dob_regex = /^([0-9]){2}(\/){1}([0-9]){2}(\/)([0-9]){4}$/;   // DD/MM/YYYY
     stringvalue = dob_regex.test(givStr); //return true or false
     return stringValue;
}
function compareDate(dateEntered) {
    
    //var dateEntered = document.getElementById("txtDateEntered").value; 
    
    //var dateEntered = $("#DateofBirth").val();
	 var strFrom = dateEntered .split('-');
	// DateFrom.setFullYear(strFrom[2], strFrom[1] - 1, strFrom[0]);
	
    var date = strFrom[2];
	//alert(date);
    var month = strFrom[1];
	//alert(month);
    var year = strFrom[0];
	//alert(year);
 
    var dateToCompare = new Date(year, month - 1, date);
    var currentDate = new Date();
 
    if (dateToCompare > currentDate) {
        alert("Date Entered should not be greater than Current Date ");
		$("#DateofBirth").val('');
		$( "#DateofBirth" ).focus();
    }
    
}