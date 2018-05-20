$(document).ready(function () {
    $('.edit').click(function (event) {
        event.preventDefault();
        var line = $(this).parents('tr').children();
        jQuery.each(line, function () {
            if ($(this).hasClass('editable'))
                if ($(this).children().attr('type') === 'checkbox') {
                    $(this).html('<input type="checkbox" ' + $(this).prop('checked', true) + '" name="' + $(this).attr('id') + '" />');
                } else {
                    $(this).html('<input type="text" class="new-input form-inline" value="' + $(this).html() + '" name="' + $(this).attr('id') + '" />');
                }
        });
        $(this).attr('type', 'hidden');
        line.find('.save').attr('type', 'submit');
    });


    $('.save').click(function () {
        $('form').attr('action', '/update');
        $(this).unbind('submit').submit()
    });
});

