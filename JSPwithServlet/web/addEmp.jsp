<div class="container my-3">
    <div class="bg-success text-center">
        <h1 class="jumbotron text-white">Add Employee</h1>
    </div>

    <!-- start form -->
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="add">

        <div class="row">
            <div class="col-md-6">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" name="name" placeholder="Full Name" required>
            </div>

            <div class="col-md-6">
                <label class="form-label">Salary</label>
                <input type="number" step="0.01" class="form-control" name="salary" placeholder="000000" required>
            </div>
        </div>

        <div class="row mt-3 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success">Save</button>
            </div>

            <div class="col-md-6">
                <button type="reset" class="btn btn-danger">Reset</button>
            </div>
        </div>
    </form>
    <!-- end form -->
</div>