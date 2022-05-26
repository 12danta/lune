<template>
<div class="page_width">
   <el-table
    ref="multipleTable"
    :data="tableData"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      label="name"
      width="200">
      <template slot-scope="scope">{{ scope.row.name }}</template>
    </el-table-column>
    <el-table-column
      prop="Composer"
      label="Composer"
      width="120">
    </el-table-column>
    <el-table-column
      prop="movement"
      label="movement"
      show-overflow-tooltip>
               <template slot-scope="scope">
                <div>
                  <ul>
                    <li v-for="item in scope.row.movements" :key="item.movement">
                      {{ item.movement }}
                    </li>
                  </ul>
                </div>
              </template>
    </el-table-column>
    <el-table-column
      prop="Introduction"
      label="Introduction"
      show-overflow-tooltip>
    </el-table-column>

      <el-table-column
      prop="tag"
      label="tag"
      width="300"
      :filters="[{ text: 'cello', value: 'cello' }, { text: 'mozart', value: 'mozart'} ,{ text: 'Snatas', value: 'Snatas' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">

      <template slot-scope="scope">
        <div class="tags">
          <el-tag
          :type="scope.row.tag === 'cello' ? 'primary' : 'success'"
          v-for="item in scope.row.tags" :key="item.row"
          disable-transitions
          class="tag"
          >
          {{item.tag}}
          </el-tag>
        </div>
      </template>

    </el-table-column>

    <el-table-column >
       <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="searching..."/>
      </template>
      <template slot-scope="scope">
        <div class="operate">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row);dialogVisible = true">Edit</el-button>
          <el-dialog
            title="Edit"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="活动名称">
                <el-input v-model="form.name"></el-input>
              </el-form-item>
              <el-form-item label="活动区域">
                <el-select v-model="form.region" placeholder="请选择活动区域">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="活动时间">
                <el-col :span="11">
                  <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                  <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                </el-col>
              </el-form-item>
              <el-form-item label="即时配送">
                <el-switch v-model="form.delivery"></el-switch>
              </el-form-item>
              <el-form-item label="活动性质">
                <el-checkbox-group v-model="form.type">
                  <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
                  <el-checkbox label="地推活动" name="type"></el-checkbox>
                  <el-checkbox label="线下主题活动" name="type"></el-checkbox>
                  <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
                </el-checkbox-group>
              </el-form-item>
              <el-form-item label="特殊资源">
                <el-radio-group v-model="form.resource">
                  <el-radio label="线上品牌商赞助"></el-radio>
                  <el-radio label="线下场地免费"></el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="活动形式">
                <el-input type="textarea" v-model="form.desc"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">立即创建</el-button>
                <el-button>Cancel</el-button>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">Cancel</el-button>
              <el-button type="primary" @click="dialogVisible = false">Confirm</el-button>
            </span>
          </el-dialog>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Delete</el-button>
        </div>
      </template>
    </el-table-column>

  </el-table>
  <div style="margin-top: 20px">
    <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button>
    <el-button @click="toggleSelection()">取消选择</el-button>
  </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      dialogVisible: false,
      tableData: [
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          Introduction: 'a introduction',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [
            {tag: 'cello'},
            {tag: 'mozart'},
            {tag: 'Snatas'}
          ]
        },
        {
          name: 'Cello Sonata in E major, Op.19',
          Composer: 'Mozart, Franz Xaver Wolfgang',
          movements: [
            {movement: 'Allegro (E major)'},
            {movement: 'Andantino espressivo (B minor, ends B major)'},
            {movement: 'Allegro vivo (E major)'}
          ],
          tags: [

            {tag: 'mozart'}
          ]
        }],
      search: '',
      multipleSelection: []
    }
  },
  methods: {
    onSubmit () {
      console.log('submit!')
    },

    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      for (let item of row.tags) {
        return item.tag === value
      }
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleClose (done) {
      this.$confirm('Are you sure to close it?')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    open () {
      this.$confirm('Are you sure to delete it?', 'Tip', {
        confirmButtonText: 'yes',
        cancelButtonText: 'no',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: 'Deleted successfully!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Deletions have been reversed'
        })
      })
    }
  }
}

</script>

<style>
  .tag{
    margin: 2px 2px;
  }
</style>
