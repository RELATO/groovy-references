$$('document').ready(function(){
    if(Lungo.dom('li[data-action=search]').length < 3) {
        Lungo.dom('input[type=search]').parent().parent().hide();
    };
    Lungo.dom('input[type=search]').on('keyup', function() {
        Lungo.dom('li[data-action=search]').each(function() {
            toSearch = Lungo.dom('input[type=search]').val().toLowerCase();
            elementText = $$(this).text().toLowerCase();
            if (elementText.match(toSearch)) {
                $$(this).show();
            } else {
                $$(this).hide();
            };
        });
    });
});

