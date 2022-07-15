var staffinfo = document.getElementsByClassName('country');
Highcharts.chart('container_for_staffLabel', {
    chart: {type: 'pie'},
    title: {text: "${averageNumber}"},
    accessibility: {announceNewData: {enabled: true}, point: {valueSuffix: 'чел.'}},
    plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.0f} чел.'}}},
    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f} чел.</b><br/>'
    },

    series: [
        {
            name: "${averageNumber}", colorByPoint: true,
            data: [
                {name: "Рабочие", y: Number(staffinfo.item(6).innerHTML), drilldown: null},
                {name: "Служащие", y: Number(staffinfo.item(8).innerHTML), drilldown: "Служащие"},
            ].filter(function(d) {return d["y"]>0})
        }
    ],
    drilldown: {
        series: [
            {
                name: "Служащие", id: "Служащие",
                data: [
                    ["Руководители", Number(staffinfo.item(10).innerHTML)],
                    ["Специалисты", Number(staffinfo.item(12).innerHTML)],
                    ["Другие", Number(staffinfo.item(8).innerHTML)-(Number(staffinfo.item(10).innerHTML)+Number(staffinfo.item(12).innerHTML))]
                ].filter(function(d) {return d[1]>0})
            }
        ]
    }
});
Highcharts.chart('container_for_expensesLabel', {
    chart: {type: 'pie'},
    title: {text: "${expensesLabel}"},
    accessibility: {
        announceNewData: {enabled: true},
        point: {valueSuffix: '₽'}
    },
    plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.1f}₽'}}},
    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}₽</b><br/>'
    },
    series: [
        {
            name: "${expensesLabel}",
            colorByPoint: true,
            data: [
                {name: "${laborCost}", y: Number(${sessionScope.companyInfo.expenses.laborCost})},
                {name: "${materialCost}", y: Number(${sessionScope.companyInfo.expenses.materialCosts})},
                {name: "${feed}", y: Number(${sessionScope.companyInfo.expenses.feed})},
                {name: "${purchasedFeed}", y: Number(${sessionScope.companyInfo.expenses.purchasedFeed})},
                {name: "${deprecation}", y: Number(${sessionScope.companyInfo.expenses.deprecation})},
                {name: "${insurancePayments}", y: Number(${sessionScope.companyInfo.expenses.insurancePayments})},
                {name: "${otherCosts}", y: Number(${sessionScope.companyInfo.expenses.otherCosts})}
            ].filter(function(d) {return d["y"]>0})
        }
    ],
});
