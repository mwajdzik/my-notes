import pandas as pd
import matplotlib.pyplot as plt

pd.set_option("display.max_columns", None)
pd.set_option("display.width", 200)

# ---

# read an Excel file
customers = pd.read_excel("../data/spreadsheet.xlsx", sheet_name="klienci")
orders = pd.read_excel("../data/spreadsheet.xlsx", sheet_name="zamowienia")

# select columns
customers = customers[["id", "imie", "nazwisko", "miasto"]]

# merge
result = orders.merge(customers, left_on="id_klienta", right_on="id")

print(customers.head())
print()

print(orders.head())
print()

print(result.head())
print()

result = result.drop(['id_zamowienia', 'id_klienta', 'id'], axis=1)
result = result[['imie', 'nazwisko', 'miasto', 'produkt', 'wartosc']]

# group

grouped = result.groupby("miasto")["wartosc"].sum()
grouped = grouped.reset_index()

# style output
result = result.style \
    .map(lambda x: 'color: red' if x > 2000 else '', ['wartosc']) \
    .map(lambda x: 'background-color: green' if x == 'Kraków' else '', ['miasto'])

# write to an Excel file
with pd.ExcelWriter("../data/output-spreadsheet.xlsx", engine="openpyxl") as writer:
    result.to_excel(writer, sheet_name="Report", index=False)
    grouped.to_excel(writer, sheet_name="Grouped", index=True)

# ---

plt.figure(figsize=(12, 8))
plt.bar(grouped["miasto"], grouped["wartosc"], color="skyblue")
plt.xlabel("Miasto")
plt.ylabel("Wartość")
plt.title("Suma wartości zamówień według miasta")
plt.xticks(rotation=45)
plt.show()

# ---

print(customers.merge(orders, left_on="id", right_on="id_klienta", how="left").head(n=10))
print()

print(customers.merge(orders, left_on="id", right_on="id_klienta", how="right").head(n=10))
print()

print(customers.merge(orders, left_on="id", right_on="id_klienta", how="outer").head(n=10))
print()
