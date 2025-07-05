# SE114-WhatTheFood-FE

## Hướng dẫn build project

- Tạo project Firebase và lấy file google-services.json, đặt vào thư mục /app, cần xác thực SHA để xử lý gửi OTP

- Đăng kí tài khoản HERE Map để lấy API key và API secret, sau đó tạo file secret.properties trong thư mục của project theo cấu trúc

```
HERE_API_KEY=YOUR_HERE_MAP_API_KEY
HERE_API_SECRET_KEY=YOUR_HERE_MAP_API_SECRET
```

- Build lại gradle và chạy project cùng với backend
