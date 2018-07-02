package me.codetalk.main;

import me.codetalk.demo.proto.PersonProto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by guobiao.xu on 2018/6/29.
 */
public class DemoMain {

    public static void main(String[] args) throws Exception {
        PersonProto.Person.PhoneNumber phoneNum = PersonProto.Person.PhoneNumber.newBuilder().setNumber("075512345678")
                .setType(PersonProto.Person.PhoneType.HOME).build();

        PersonProto.Person person = PersonProto.Person.newBuilder().setId(1)
                .setName("Ted")
                .setEmail("ted@mail.com")
                .addPhone(phoneNum)
                .build();

        byte[] bytes = person.toByteArray();

        PersonProto.Person person2 = PersonProto.Person.parseFrom(bytes);
        System.out.println("Id = " + person2.getId());
        System.out.println("Name = " + person2.getName());
        System.out.println("Email = " + person2.getEmail());

        List<PersonProto.Person.PhoneNumber> phoneList = person2.getPhoneList();
        System.out.println("Phone = " + phoneList.get(0));
    }

}
