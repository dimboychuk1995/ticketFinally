/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function call() {
        var msg   = $('#mainFormToSale').serialize();
  $.ajax({
        type: 'POST',
        url: '../SaleController',
        data: msg,
    success: function(data) {
        alert('it good');
        $('#results').html(data);
    },
    error:  function(xhr, str){
        alert('Помилка запису даних: ' + xhr.responseCode);
    }
  });

}
