package top.moxingwang.demo.classloader.testobj;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestService {

    public static final String UID = "uuid";

    private Long id;
    private String name;
    private String address;
    private long number;
    private List list;
    private String[] names;


    @Override
    public String toString() {
        return "TestService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", list=" + list +
                ", names=" + Arrays.toString(names) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestService that = (TestService) o;
        return number == that.number &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(list, that.list) &&
                Arrays.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, address, number, list);
        result = 31 * result + Arrays.hashCode(names);
        return result;
    }

    public static String getUID() {
        return UID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
