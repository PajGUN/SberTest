SberbankTest (JavaEE7, JSP, JMS(ActiveMQ))

Два сервиса Производитель и потребитель.
	В первый посредствам html формы (GET :8080/api/1.0/message/send) поступает запрос на отправку сообщения.
Поступившие параметры преобразуются в объект класса SberMessage, который сериализуется в xml и отправляется в очередь.

	Второй сервис Потребителя вычитывает сообщения из очереди и добавляет в List<SberMessage>.
При соверешние запроса (GET :8090/api/1.0/message/getall) клиенту отображается список всех поступивших сообщений с сортировкой по дате. 