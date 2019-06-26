const express = require("express");
const router = express.Router();
const gravatar = require("gravatar");
const bcrypt = require("bcryptjs");
const { check, validationResult } = require("express-validator/check");

const Users = require("../../models/User");

// @route  POST api/users
// @desc   register user
// @access public
router.post(
  "/",
  [
    check("name", "Name is required")
      .not()
      .isEmpty(),
    check("email", "Please enter a valid email").isEmail(),
    check(
      "password",
      "please enter a password with 6 or more characters"
    ).isLength({ min: 6 })
  ],
  async (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { name, email, password } = req.body;

    try {
      // See if the user exists
      let user = await Users.findOne({ email });

      if (user) {
        return res.status(400).json({ message: "User already exists" });
      }

      // Get user's gravatar
      const avatar = gravatar.url(email, {
        s: 200,
        r: "pg",
        d: "mm"
      });

      user = new User({
        name,
        email,
        password,
        avatar
      });

      // Encrypt the password
      const salt = await bcrypt.genSalt(10);

      user.password = await bcrypt.hash(password, salt);

      await user.save();
      // Return json webtoken
      res.send("User registered");
    } catch (err) {
      console.log(err);
      res.status(500).send("Server error");
    }
  }
);

module.exports = router;
