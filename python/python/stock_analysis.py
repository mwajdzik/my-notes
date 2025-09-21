import pandas as pd
import matplotlib.pyplot as plt


def load_stock(ticker):
    df = pd.read_csv(f'../data/daily/pl/wse stocks/{ticker}.txt')
    df = df[['<DATE>', '<OPEN>', '<CLOSE>']]
    df['date'] = pd.to_datetime(df['<DATE>'].astype(str), format='%Y%m%d')
    df = df[df['date'] > '2025-01-01']

    first_value = df.iloc[0]['<OPEN>']
    df['change'] = (100 * df['<CLOSE>'] / first_value) - 100

    return df[['date', 'change']]


tickers = ['apt', 'cbf', 'dnp', 'dig', 'elt', 'kru', 'sho', 'sgn', 'snt', 'vot']
data = [{'ticker': ticker, 'df': load_stock(ticker)} for ticker in tickers]

plt.figure(figsize=(12, 8))

for d in data:
    df = d['df']
    ticker = d['ticker']

    plt.plot(df['date'], df['change'], label=ticker)

plt.xlabel('Date')
plt.ylabel('Change')
plt.legend()

plt.show()
