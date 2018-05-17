$(document).ready(function () {
    $('.edit').click(function (event) {
        event.preventDefault();
        jQuery.each($(this).parents('tr').children(), function () {
            if ($(this).hasClass('editable'))
                $(this).html('<input type="text" class="new-input" value="' + $(this).html() + '"/>');
        });

        $(this).addClass('save');
        $(this).removeClass('edit');
        $(this).attr('value', 'Save');
        $(this).attr("target", "_blank");
    });
    $('.delete').click(function (event) {
        event.preventDefault();
        $('form').attr('action', '/');
        $(this).unbind('submit').submit()
    });
    $('.save').click(function (event) {
        $('form').attr('action', '/update');
        $(this).unbind('submit').submit()
    });
});

