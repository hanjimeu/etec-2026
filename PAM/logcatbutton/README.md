# Logcat App

Aplicativo Android desenvolvido em **Kotlin + Jetpack Compose** para demonstrar na prática os níveis de log do Android (`Log.e`, `Log.w`, `Log.d`, `Log.i`) usando a API `android.util.Log`.

## Como funciona

A tela exibe um campo para digitar o nome e quatro botões de menção. Cada botão registra uma mensagem no Logcat com base na menção selecionada.

| Botão | Método | Nível do Log | Mensagem registrada |
|-------|--------|--------------|---------------------|
| 🔴 **Menção I** | `Log.e()` | Erro | Informa que a menção é I |
| 🟠 **Menção R** | `Log.w()` | Aviso | Informa que a menção é R |
| 🟢 **Menção B** | `Log.d()` | Debug | Informa que a menção é B |
| 🔵 **Menção MB** | `Log.i()` | Informação | Informa que a menção é MB |

> O nome digitado é incluído na mensagem exibida no Logcat, simulando um cenário real de uso.

---

## Screenshots

### Tela do app
![Tela](<img width="1919" height="921" alt="image" src="https://github.com/user-attachments/assets/385da654-b31d-453c-95dc-37f9a359220a" />
)

### Saída no Logcat
![Logcat](images\logcat.jpeg)

### Android Studio completo
![Android Studio](images\projeto.jpeg)

### Projeto feito por
Mariana dos Santos Moreira
