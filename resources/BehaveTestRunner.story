Scenario: Wylogowywanie

Given Jestem zalogowany jako admin
When Wyloguje się
Then Zobaczę przycisk zaloguj

Scenario: Nie zaloguje sie

Given Jestem wylogowany
When Spróbuję się zalogować złymi danymi
Then Zobaczę komunikat o błędzie

Scenario: Zaloguje się

Given Jestem wylogowany
When Spróbuję się zalogować dobrymi danymi
Then Zobaczę mój login

Scenario: Nie dodam niepoprawnych autorów

Given Jestem zalogowany jako admin na stronie autorów
When Spróbuję dodać niepoprawnych autorów
Then Zobaczę komunikat o niepowodzeniu

Scenario: Wejdę na stronę główną

Given Jestem wylogowany
When spróbuję wejść na stronę
Then Zobaczę tytuł strony głównej


Scenario: jakiś banał

Given Jestem wylogowany
When spróbuję wejść na stronę
Then Zobaczę tytuł strony głównej

