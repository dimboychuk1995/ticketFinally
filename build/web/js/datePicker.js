/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( function() {
     $( "#datepicker" ).datepicker({
     changeMonth:true,
     changeYear:true,
     yearRange:"2016:2050",
     dateFormat:"yy-mm-dd",
     duration:"slow"
 }); 
});
