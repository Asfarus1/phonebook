(function($) {

    function pagination($element) {
        var count = 3,
            page = $element.attr('data-page'),
            size = $element.attr('data-size'),
            $pagination = $('<ul />').addClass('pagination');

        if (size <= 1) {
            return;
        }

        var indexFrom = Math.ceil(page - count/2);

        if (indexFrom < 0) {
            indexFrom = 0;
        }

        indexTo = indexFrom + count;

        if(indexTo > size){
            indexTo = size;
            indexFrom = size-count;
            if (indexFrom < 0) {
                indexFrom = 0;
            }
        }
        if(indexFrom>0) {
            $pagination.append(
                $('<li />')
                    .addClass(page == 0 ? 'disabled' : '')
                    .append(
                    $('<a />')
                        .attr({href: '?page=0', title: 'Previous'})
                        .html('<span aria-hidden="true">&laquo; Первая</span>')
                )
            );
        }

        for (var i = indexFrom; i < indexTo; i++) {
            $pagination.append(
                $('<li />')
                    .addClass( i == page ? 'active' : '')
                    .append(
                        $('<a />')
                            .attr('href', '?page=' + i)
                            .html(i + 1)
                    )
            );
        }

        if(indexTo<size) {
            $pagination.append(
                $('<li />')
                    .addClass(page == size ? 'disabled' : '')
                    .append(
                    $('<a />')
                        .attr({href: '?page=' + (size - 1), title: 'Next'})
                        .html('<span aria-hidden="true">Последняя &raquo;</span>')
                )
            );
        }

        $element.append($pagination);
    }

    $.fn.pagination = function() {
        return this.each(function() {
            pagination($(this));
        })
    };


    $(document).ready(function() {
        $('.pagination-container').pagination();
    });
})(jQuery);