# Задание
Для работы предоставляется API по URL - http://94.198.50.185:7081/api/users </br>
Ваша задача: Последовательно выполнить следующие операции и получить код для проверки на платформе: </br>
1.Получить список всех пользователей </br>
2.Когда вы получите ответ на свой первый запрос, вы должны сохранить свой session id, который получен через cookie. Вы получите его в заголовке ответа set-cookie. Поскольку все действия происходят в рамках одной сессии, все дальнейшие запросы должны использовать полученный session id ( необходимо использовать заголовок в последующих запросах ) </br>
3.Сохранить пользователя с id = 3, name = James, lastName = Brown, age = на ваш выбор. В случае успеха вы получите первую часть кода. </br>
4.Изменить пользователя с id = 3. Необходимо поменять name на Thomas, а lastName на Shelby. В случае успеха вы получите еще одну часть кода. </br>
5.Удалить пользователя с id = 3. В случае успеха вы получите последнюю часть кода. </br>
В результате выполненных операций вы должны получить итоговый код, сконкатенировав все его части. Количество символов в коде = 18. </br>