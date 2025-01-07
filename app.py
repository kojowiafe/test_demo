from flask import Flask, redirect, render_template, request
# import csv

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

# @app.route('/registrants')
# def registrants():
#     return render_template('registered.html', students=students)

@app.route('/register', methods=['POST'])
def register():
    if not request.form.get('name') or not request.form.get('dorm'):
        return render_template('failure.html')
    with open('registered.txt', 'a') as file:
        # writer = csv.writer(file)
        # writer.writerow((request.form.get('name') +" from " +request.form.get('dorm')))
        file.write(f'{request.form.get('name')} from {request.form.get('dorm')}\n')
        return render_template('success.html')
    
@app.route('/registered')
def registered():
    with open('registered.txt', 'r') as file:
        # reader = csv.reader(file)
        # students = list(reader)
        students = file.readlines()
        return render_template('registered.html', students=students)

if __name__ == '__main__':
    app.run(debug=True)