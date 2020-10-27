<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Send message</title>
</head>

<body>
<h2>Message</h2>

<form action="/api/1.0/message/send" method="POST">
    <label for="id">Id</label>
    <input type="number" min="0"  name="id" id="id" placeholder="Please enter the id" required/>
    <p>
    <label for="options">Options</label>
        <select name="options" id="options" required >
            <option disabled>Select option</option>
            <option value="First">First</option>
            <option value="Second">Second</option>
            <option value="Third">Third</option>
            <option value="Fourth">Fourth</option>
            <option value="Fifth">Fifth</option>
        </select>
    <p>
    <label for="date">Date</label>
    <input type="date"  name="date" id="date" required/>
    <p>
    <input type="submit" value="Send" name="send" />
</form>

</body>

</html>