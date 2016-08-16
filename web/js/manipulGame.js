function add_games() {
                        var objTo = document.getElementById('addGameJS')
                        var divtest = document.createElement("div");
                        divtest.innerHTML = '<div>\n\
                                            <br>\n\
                                            <form  action="../GamesController" method="POST" >\n\
                                            <div class="col-xs-1">\n\
                                            <input id = "inputAddTime" class="form-control"type="text" name= "time"    value="" size="3" placeholder = "час"/>\n\
                                            </div>\n\
                                            <div class="col-xs-2">\n\
                                            <input class="form-control" type="text" name= "date"    value="" size="20" placeholder = "дата матчу"/>\n\
                                            </div>\n\
                                            <div class="col-xs-2">\n\
                                            <input class="form-control" type="text" name= "owner"   value="" size="20" placeholder = "господар"/>\n\
                                            </div>\n\
                                            <div class="col-xs-2">\n\
                                            <input class="form-control" type="text" name= "guest"   value="" size="20" placeholder = "гості"/>\n\
                                            </div>\n\
                                            <div class="col-xs-2">\n\
                                            <input class="form-control" type="text" name= "place"   value="" size="20" placeholder = "місце проведення"/>\n\
                                            </div>\n\
                                            <input id="insertGame" type="hidden" name="insertGame" value="insertGame" />\n\
                                            <button class = "btn btn-success" type="submit">зберегти</button>\n\
                                            </form>\n\
                                            </div> \n\
                                            <br>';
                                            
                        objTo.appendChild(divtest)
                        $("#addG").attr('disabled',true);
                    };
                    
function edit(){    
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

function sbmit(iForm){
    
    iForm.submit();
}
function addGame(){
    $('#addGameJS').load('addGame.jsp');
}


