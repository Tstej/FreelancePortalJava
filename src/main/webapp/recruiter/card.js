$(function() {

    var $cardForm = $("#cardform");

    $cardForm.validate({
        rules: {
            cno: {
                required: true,
                minlength: 16,
                maxlength: 17

            },
            cvv: {
                required: true,
                numericonly: true,
                minlength: 3,
                maxlength: 4
            },
            dt: {
                required: true,
                carddate:true
            },
            cname: {
                required: true,
                lattersonly: true
            }
        },
        messages: {
            cno: {
                required: 'card no required',
                minlength: 'minimum 16 digit',
                maxlength: 'maxmium 17 digit'

            },
            cvv: {
                required: 'cvv required',
                numericonly: 'invalid cvv',
                minlength: 'minumum 3 digit',
                maxlength: 'maximum 4 digit'
            },
            dt: {
                required:'expiry date required',
                carddate:'invalid date'
            },
            cname: {
                required: 'card holder name must be required',
                lattersonly: 'invalid name'
            }
        }
    })

    jQuery.validator.addMethod('lattersonly', function(value, element) {
        return /^[^-\s][a-zA-Z_\s-]+$/.test(value);
    });

    jQuery.validator.addMethod('numericonly', function(value, element) {
        return /^[^-\s][0-9]+$/.test(value);
    });

    jQuery.validator.addMethod('all', function(value, element) {
        return /^[^-\s][a-zA-Z0-9_\s-]+$/.test(value);
    });

    jQuery.validator.addMethod('carddate', function(value, element) {
        return /^(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})$/mg.test(value);
    });

})