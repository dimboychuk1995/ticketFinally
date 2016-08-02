function add_games() {
    var objTo = document.getElementById('addSubJs')
    var divtest = document.createElement("div");
    divtest.innerHTML = '<div>\n\
                        <br>\n\
                        <form  action="../SubscriptionController" method="POST">\n\
                        <div class="col-xs-2">\n\
                        <input class="form-control" type="text" id="PIP" name="PIP" value="" placeholder="ПІП"/>\n\
                        </div>\n\
                        <div class="col-xs-2">\n\
                        <select class="form-control" name="season">\n\
                         <option id="season">2015-2016</option>\n\
                         <option id="season">2016-2017</option>\n\
                         <option id="season">2017-2018</option>\n\
                         <option id="season">2018-2019</option>\n\
                        </select>\n\
                        </div>\n\
                        <div class="col-xs-2">\n\
                        <input class="form-control" type="text" id="sector" name="sector" value="" placeholder="sector"/>\n\
                        </div>\n\
                        <div class="col-xs-2">\n\
                        <input class="form-control" type="text" id="row" name="row" value="" placeholder="row" />\n\
                        </div>\n\
                        <div class="col-xs-2">\n\
                        <input class="form-control" type="text" id="number" name="number" value="" placeholder="number"/>\n\
                        </div>\n\
                        <button id="btn_add" value="delete" type="submit" class="btn btn-success">Зберегти</button>\n\
                        </form>\n\
                        </div> \n\
                        <br>';  
            objTo.appendChild(divtest)
            $("#addS").attr('disabled',true);
};

function editS(){    
                var inputs = document.getElementsByClassName('col-xs-12');
                for(var i = 0; i < inputs.length; i++) {
                    inputs[i].disabled = false;
                }                 
                var div = document.getElementsByClassName('btn btn-mini btn-warning');
                for (var j = 0; j < div.length; j++){
                
                    if(div[j].style.display == 'none') {
                        div[j].style.display = 'block';
                    }
                    else {
                        div[j].style.display = 'block';
                    }  
                }      
};
