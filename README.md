# edisoft-exersice
Разработать программу, которая описывает работу фабрики по выпуску автомобилей. Конструкция автомобиля должна описывать :

    кузов (тип, цвет, кол-во дверей, VIN),
    двигатель (тип, объем, мощность кВт, серийный номер),
    трансмиссию (тип, серийный номер).
Программа должна быть выполнена по архитектуре EAR упаковки с использованием менеджера зависимостей и систему сборки Maven (версия 3 и выше) с возможностью деплоя на сервер приложения (при помощи maven плагина).

В качестве ORM системы, необходимо использовать библиотеку Hibernate версии 4 и выше. Технология спецификаций написания кода EJB 3.1. Сервер приложений должен быть либо JBOSS 7., либо EAP 6. Программа должна обладать как REST интерфейсом, так и примитивным UI интерфейсом, сгенерированным с использованием JSP. Функции управляющих бинов и REST интерфейса:

    возможность создавать, модифицировать и удалять каждый из вышеописанных узлов в отдельности,
    собирать из созданных узлов автомобиль в целом,
    контролировать типы связи объектов в соответствии с реальным миром (нельзя один и тот же двигатель устанавливать в 2 разные машины и т.д.),
    просматривать результат получившегося автопарка с возможностью постраничного вывода и поддержкой поиска и сортировки ( поиск, сортировка и постраничный вывод следует поддержать для всех списков, например, работа с компонентами автомобиля),
    иметь возможность разбирать машины на запчасти, для повторного использования.
Формат данных для REST интерфейса JSON. Плюсом будет считаться поддержка XML.

Ориентировочный срок выполнения - неделя, +/-

Комментарий
К сожалению не успел реализовать несколько пунктов из задания, а именно:
1. Отсутствует возможность можификации автомобиля и узлов
2. Отсутствует поддержка поиска и сортировки
3. Поддержка XML для REST реализована только в одном методе для TypeBody

В pom.xml убрал credentials для плагина jboss-as-maven-plugin
