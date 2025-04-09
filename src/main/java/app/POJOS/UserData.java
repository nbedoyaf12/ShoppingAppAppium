package app.POJOS;

public class UserData {

    private LoginData login;
    private AddressData address;
    private CardData card;

    public LoginData getLogin() {
        return login;
    }

    public void setLogin(LoginData login) {
        this.login = login;
    }

    public AddressData getAddress() {
        return address;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }

    public CardData getCard() {
        return card;
    }

    public void setCard(CardData card) {
        this.card = card;
    }
}
