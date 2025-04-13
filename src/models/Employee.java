
package models;

public class Employee {
    private int id;
    private String name;
    private String email;

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public int getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }

    // Метод для преобразования объекта в строку CSV
    public String toCSV() {
        return id + "," + name + "," + email;
    }

    // Метод для преобразования объекта в JSON (с использованием библиотеки Gson)
    public String toJSON() {
        // Этот метод нужно будет вызывать после добавления зависимости Gson в проект
        return "{\"id\": " + id + ", \"name\": \"" + name + "\", \"email\": \"" + email + "\"}";
    }

    // Статический метод для создания объекта Employee из строки CSV
    public static Employee fromCSV(String csvLine) {
        String[] tokens = csvLine.split(",");
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        String email = tokens[2];
        return new Employee(id, name, email);
    }

    // Статический метод для создания объекта Employee из строки JSON
    public static Employee fromJSON(String jsonLine) {
        // Парсинг JSON с использованием Gson (если в проекте подключена эта библиотека)
        // Пример:
        // JsonObject jsonObject = JsonParser.parseString(jsonLine).getAsJsonObject();
        // int id = jsonObject.get("id").getAsInt();
        // String name = jsonObject.get("name").getAsString();
        // String email = jsonObject.get("email").getAsString();
        // return new Employee(id, name, email);
        return null; // Примерный код, оставьте его для дальнейшего использования
    }
}

