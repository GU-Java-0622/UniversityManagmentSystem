package ru.geekbrains.com.dto;

import ru.geekbrains.com.entity.ProfileStatus;

import java.util.Set;

public class ProfileGetAllDtoRequest {
    private Integer page;//текущая страница
    private Integer itemInPage;//количество на страницу
    private String sortField;// по какому полю сортировка
    private Boolean directSort;// по возрастанию или убыванию
    private String searchField;//поле по которому что то ищем
    private String searchValue;// что ищем в этом поле
    private Set<ProfileStatus> status;
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getItemInPage() {
        return itemInPage;
    }

    public void setItemInPage(Integer itemInPage) {
        this.itemInPage = itemInPage;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Boolean getDirectSort() {
        return directSort;
    }

    public void setDirectSort(Boolean directSort) {
        this.directSort = directSort;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Set<ProfileStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<ProfileStatus> status) {
        this.status = status;
    }
}
