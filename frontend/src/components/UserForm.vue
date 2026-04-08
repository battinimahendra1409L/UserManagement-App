<template>
  <div class="container">
    <h1>User Registration</h1>

    <!-- FORM -->
    <div class="form-card">
      <input v-model="user.fullName" placeholder="Full Name" />
      <span class="error">{{ errors.fullName }}</span>

      <input v-model="user.email" placeholder="Email" />
      <span class="error">{{ errors.email }}</span>

      <input v-model="user.mobile" placeholder="Mobile" />
      <span class="error">{{ errors.mobile }}</span>

      <input v-model="user.password" type="password" placeholder="Password" />
      <span class="error">{{ errors.password }}</span>

      <input type="date" v-model="user.dob" />

      <button @click="saveUser">
        {{ editId ? "Update User" : "Save User" }}
      </button>
    </div>

    <!-- TABLE -->
    <h2>User List</h2>

    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Mobile</th>
          <th>DOB</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="u in users" :key="u.id">
          <td>{{ u.fullName }}</td>
          <td>{{ u.email }}</td>
          <td>{{ u.mobile }}</td>
          <td>{{ u.dob }}</td>
          <td>
            <button class="edit" @click="editUser(u)">Edit</button>
            <button class="delete" @click="deleteUser(u.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      user: {
        fullName: "",
        email: "",
        mobile: "",
        password: "",
        dob: ""
      },
      users: [],
      editId: null,
      errors: {}
    };
  },

  methods: {
    // VALIDATION
    validate() {
      this.errors = {};

      if (!this.user.fullName) this.errors.fullName = "Name required";

      if (!this.user.email) {
        this.errors.email = "Email required";
      } else if (!/\S+@\S+\.\S+/.test(this.user.email)) {
        this.errors.email = "Invalid email";
      }

      if (!this.user.mobile) this.errors.mobile = "Mobile required";
      if (!this.user.password) this.errors.password = "Password required";

      return Object.keys(this.errors).length === 0;
    },

    // SAVE / UPDATE
    async saveUser() {
      if (!this.validate()) return;

      try {
        if (this.editId) {
          await axios.put(
            "http://localhost:8080/api/users/${this.editId",
            this.user
          );
          this.editId = null;
        } else {
          await axios.post("http://localhost:8080/api/users", this.user);
        }

        // RESET FORM
        this.user = {
          fullName: "",
          email: "",
          mobile: "",
          password: "",
          dob: ""
        };

        this.getUsers();
      } catch (e) {
        alert(e.response?.data || "Server error");
      }
    },

    // GET USERS
    async getUsers() {
      try {
        const res = await axios.get("http://localhost:8080/api/users");
        this.users = res.data;
      } catch (e) {
        console.log(e);
      }
    },

    // EDIT
    editUser(u) {
      this.user = { ...u };
      this.editId = u.id;
    },

    // DELETE
  async deleteUser(id) {
  if (!confirm("Are you sure to delete?")) return;

  await axios.delete("http://localhost:8080/api/users/${id}");
  this.getUsers();
}
  },

  mounted() {
    this.getUsers();
  }
};
</script>

<style>
body {
  margin: 0;
  font-family: Arial;
  background: linear-gradient(135deg, #1e3c72, #2a5298);
}

/* Container */
.container {
  padding: 20px;
  color: white;
  text-align: center;
}

/* Form Card */
.form-card {
  background: rgba(255, 255, 255, 0.1);
  padding: 20px;
  border-radius: 12px;
  width: 300px;
  margin: auto;
  backdrop-filter: blur(10px);
}

/* Inputs */
input {
  width: 90%;
  padding: 10px;
  margin: 8px 0;
  border-radius: 8px;
  border: none;
  outline: none;
}

/* Button */
button {
  background: linear-gradient(to right, #0072ff, #00c6ff);
  color: white;
  padding: 10px;
  border: none;
  border-radius: 8px;
  width: 100%;
  cursor: pointer;
  margin-top: 10px;
}

button:hover {
  transform: scale(1.05);
}

/* Table */
table {
  width: 80%;
  margin: 20px auto;
  border-collapse: collapse;
  background: rgba(255, 255, 255, 0.1);
}

th,
td {
  padding: 10px;
  border: 1px solid white;
}

/* Buttons */
.edit {
  background: orange;
}

.delete {
  background: red;
}

/* Error */
.error {
  color: yellow;
  font-size: 12px;
}
</style>