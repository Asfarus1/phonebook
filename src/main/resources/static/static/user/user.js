$(document).ready(function() {

    $("#birthDate").datepicker({
        dateFormat: "dd.mm.yy",
        changeYear: true,
        changeMonth: true,
        defaultDate: '-20y',
        maxDate: '-1e'
    });

    $("#city").autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "/city/find",
                data: {
                    title: request.term
                },
                success: function (data) {
                    response(data);
                }
            });
        },

        minLength: 0,
        open: function () {
            $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close: function () {
            $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }
    });

    $("#street").autocomplete({
        source: function (request, response) {
            $.ajax({
               url: "/street/find",
               data: {
                   city: $("#city").val(),
                   title: request.term
               },
               success: function (data) {
                   response(data);
               }
           });
        },
        minLength: 0,
        open: function () {
            $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close: function () {
            $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }
    });
});