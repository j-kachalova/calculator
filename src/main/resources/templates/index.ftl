<html>
    <head>

    </head>
    <body>
        <form action="/calculate " method="get">
            <div><label> Зарплата: <input type="text" name="salary"/> </label></div>
            <div><label> Количество дней: <input type="text" name="days"/> </label></div>
            <div> Выплатить ${pay} рублей</div>
            <div> <input type="date"  name="vacation-start"  />
                <input type="date"  name="vacation-end"  />
            </div>
            <div><input class="button" type="submit" value="Посчитать"/></div>
        </form>
    </body>
</html>